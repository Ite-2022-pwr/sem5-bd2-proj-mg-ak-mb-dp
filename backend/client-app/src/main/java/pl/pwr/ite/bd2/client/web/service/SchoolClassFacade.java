package pl.pwr.ite.bd2.client.web.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.SchoolClassDto;
import pl.pwr.ite.bd2.client.web.mapper.SchoolClassMapper;
import pl.pwr.ite.bd2.model.entity.SchoolClass;
import pl.pwr.ite.bd2.model.filter.SchoolClassFilter;
import pl.pwr.ite.bd2.service.SchoolClassService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;
import pl.pwr.ite.bd2.web.exception.ApplicationError;
import pl.pwr.ite.bd2.web.exception.ApplicationException;

import java.util.UUID;

@Component
public class SchoolClassFacade extends EntityServiceFacade<SchoolClass, SchoolClassFilter, SchoolClassService, SchoolClassDto, SchoolClassDto.Properties, SchoolClassMapper> {
    public SchoolClassFacade(SchoolClassService service, SchoolClassMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }

    @Transactional
    public SchoolClass create(SchoolClassDto dto) {
        var schoolClass = new SchoolClass();
        return saveAndFlush(setValues(schoolClass, dto));
    }

    @Transactional
    public SchoolClass update(UUID id, SchoolClassDto dto) {
        var schoolClass = getById(id);
        if (schoolClass == null) {
            throw new ApplicationException(ApplicationError.SchoolClassNotFound);
        }
        return saveAndFlush(setValues(schoolClass, dto));
    }

    private SchoolClass setValues(SchoolClass schoolClass, SchoolClassDto dto) {
        schoolClass.setName(schoolClass.getName());
        schoolClass.setYearOfStudy(schoolClass.getYearOfStudy());
        schoolClass.setYearStarted(schoolClass.getYearStarted());
        return schoolClass;
    }
}
