package pl.pwr.ite.bd2.client.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.GradeDto;
import pl.pwr.ite.bd2.client.web.mapper.GradeMapper;
import pl.pwr.ite.bd2.model.entity.Grade;
import pl.pwr.ite.bd2.model.filter.GradeFilter;
import pl.pwr.ite.bd2.service.GradeService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;

@Component
public class GradeFacade extends EntityServiceFacade<Grade, GradeFilter, GradeService, GradeDto, GradeDto.Properties, GradeMapper> {

    public GradeFacade(GradeService service, GradeMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }
}
