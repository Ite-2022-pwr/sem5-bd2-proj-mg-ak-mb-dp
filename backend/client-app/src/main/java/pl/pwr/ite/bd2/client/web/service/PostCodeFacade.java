package pl.pwr.ite.bd2.client.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.PostCodeDto;
import pl.pwr.ite.bd2.client.web.mapper.PostCodeMapper;
import pl.pwr.ite.bd2.model.entity.PostCode;
import pl.pwr.ite.bd2.model.filter.PostCodeFilter;
import pl.pwr.ite.bd2.service.PostCodeService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;

@Component
public class PostCodeFacade extends EntityServiceFacade<PostCode, PostCodeFilter, PostCodeService, PostCodeDto, PostCodeDto.Properties, PostCodeMapper> {
    public PostCodeFacade(PostCodeService service, PostCodeMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }
}
