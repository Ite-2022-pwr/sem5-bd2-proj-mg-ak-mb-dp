package pl.pwr.ite.bd2.client.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.SchoolClassDto;
import pl.pwr.ite.bd2.client.web.mapper.SchoolClassMapper;
import pl.pwr.ite.bd2.model.entity.SchoolClass;
import pl.pwr.ite.bd2.model.filter.SchoolClassFilter;
import pl.pwr.ite.bd2.service.SchoolClassService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;

@Component
public class SchoolClassFacade extends EntityServiceFacade<SchoolClass, SchoolClassFilter, SchoolClassService, SchoolClassDto, SchoolClassDto.Properties, SchoolClassMapper> {
    public SchoolClassFacade(SchoolClassService service, SchoolClassMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }
}
