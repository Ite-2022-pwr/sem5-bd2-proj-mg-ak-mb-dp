package pl.pwr.ite.bd2.client.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.MessageDto;
import pl.pwr.ite.bd2.client.web.mapper.MessageMapper;
import pl.pwr.ite.bd2.model.entity.Message;
import pl.pwr.ite.bd2.model.filter.MessageFilter;
import pl.pwr.ite.bd2.service.MessageService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;

@Component
public class MessageFacade extends EntityServiceFacade<Message, MessageFilter, MessageService, MessageDto, MessageDto.Properties, MessageMapper> {

    public MessageFacade(MessageService service, MessageMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }
}
