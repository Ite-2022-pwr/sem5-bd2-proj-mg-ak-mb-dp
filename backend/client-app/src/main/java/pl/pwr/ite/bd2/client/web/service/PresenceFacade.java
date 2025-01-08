package pl.pwr.ite.bd2.client.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.PresenceDto;
import pl.pwr.ite.bd2.client.web.mapper.PresenceMapper;
import pl.pwr.ite.bd2.model.entity.Presence;
import pl.pwr.ite.bd2.model.filter.PresenceFilter;
import pl.pwr.ite.bd2.service.PresenceService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;

@Component
public class PresenceFacade extends EntityServiceFacade<Presence, PresenceFilter, PresenceService, PresenceDto, PresenceDto.Properties, PresenceMapper> {
    public PresenceFacade(PresenceService service, PresenceMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }
}
