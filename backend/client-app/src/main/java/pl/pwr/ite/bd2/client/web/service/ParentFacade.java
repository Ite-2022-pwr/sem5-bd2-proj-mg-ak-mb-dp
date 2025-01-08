package pl.pwr.ite.bd2.client.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.ParentDto;
import pl.pwr.ite.bd2.client.web.mapper.ParentMapper;
import pl.pwr.ite.bd2.model.entity.Parent;
import pl.pwr.ite.bd2.model.filter.ParentFilter;
import pl.pwr.ite.bd2.service.ParentService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;

@Component
public class ParentFacade extends EntityServiceFacade<Parent, ParentFilter, ParentService, ParentDto, ParentDto.Properties, ParentMapper> {
    public ParentFacade(ParentService service, ParentMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }
}
