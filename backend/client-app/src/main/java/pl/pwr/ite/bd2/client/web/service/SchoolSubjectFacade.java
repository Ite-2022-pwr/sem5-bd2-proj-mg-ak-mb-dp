package pl.pwr.ite.bd2.client.web.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.SchoolSubjectDto;
import pl.pwr.ite.bd2.client.web.mapper.SchoolSubjectMapper;
import pl.pwr.ite.bd2.model.entity.SchoolSubject;
import pl.pwr.ite.bd2.model.filter.SchoolSubjectFilter;
import pl.pwr.ite.bd2.service.SchoolSubjectService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;
import pl.pwr.ite.bd2.web.exception.ApplicationError;
import pl.pwr.ite.bd2.web.exception.ApplicationException;

import java.util.UUID;

@Component
public class SchoolSubjectFacade extends EntityServiceFacade<SchoolSubject, SchoolSubjectFilter, SchoolSubjectService, SchoolSubjectDto, SchoolSubjectDto.Properties, SchoolSubjectMapper> {
    public SchoolSubjectFacade(SchoolSubjectService service, SchoolSubjectMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }

    @Transactional
    public SchoolSubject create(SchoolSubjectDto dto) {
        var schoolSubject = new SchoolSubject();
        return saveAndFlush(setValues(schoolSubject, dto));
    }

    @Transactional
    public SchoolSubject update(UUID id, SchoolSubjectDto dto) {
        var schoolSubject = getById(id);
        if (schoolSubject == null) {
            throw new ApplicationException(ApplicationError.SchoolSubjectNotFound);
        }
        return saveAndFlush(setValues(schoolSubject, dto));
    }

    private SchoolSubject setValues(SchoolSubject schoolSubject, SchoolSubjectDto dto) {
        schoolSubject.setLinkToSubjectProgram(dto.getLinkToSubjectProgram());
        schoolSubject.setSchoolYear(dto.getSchoolYear());
        schoolSubject.setName(dto.getName());
        return schoolSubject;
    }
}
