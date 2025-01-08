package pl.pwr.ite.bd2.client.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.SchoolSubjectDto;
import pl.pwr.ite.bd2.client.web.mapper.SchoolSubjectMapper;
import pl.pwr.ite.bd2.model.entity.SchoolSubject;
import pl.pwr.ite.bd2.model.filter.SchoolSubjectFilter;
import pl.pwr.ite.bd2.service.SchoolSubjectService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;

@Component
public class SchoolSubjectFacade extends EntityServiceFacade<SchoolSubject, SchoolSubjectFilter, SchoolSubjectService, SchoolSubjectDto, SchoolSubjectDto.Properties, SchoolSubjectMapper> {
    public SchoolSubjectFacade(SchoolSubjectService service, SchoolSubjectMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }
}
