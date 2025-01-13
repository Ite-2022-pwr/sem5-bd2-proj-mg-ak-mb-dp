package pl.pwr.ite.bd2.client.web.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.MessageDto;
import pl.pwr.ite.bd2.client.web.mapper.MessageMapper;
import pl.pwr.ite.bd2.model.entity.Message;
import pl.pwr.ite.bd2.model.filter.MessageFilter;
import pl.pwr.ite.bd2.service.MessageService;
import pl.pwr.ite.bd2.service.UserService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;
import pl.pwr.ite.bd2.web.exception.ApplicationError;
import pl.pwr.ite.bd2.web.exception.ApplicationException;

import java.util.UUID;

@Component
public class MessageFacade extends EntityServiceFacade<Message, MessageFilter, MessageService, MessageDto, MessageDto.Properties, MessageMapper> {

    private final UserService userService;

    public MessageFacade(MessageService service, MessageMapper mapper, SecurityFacade securityFacade, UserService userService) {
        super(service, mapper, securityFacade);
        this.userService = userService;
    }

    @Transactional
    public Message create(MessageDto dto) {
        var message = new Message();
        return saveAndFlush(setValues(message, dto));
    }

    @Transactional
    public Message update(UUID id, MessageDto dto) {
        var message = getById(id);
        if (message == null) {
            throw new ApplicationException(ApplicationError.MessageNotFound);
        }
        return saveAndFlush(setValues(message, dto));
    }

    private Message setValues(Message message, MessageDto dto) {
        message.setContent(dto.getContent());
        message.setDateSent(dto.getDateSent());

        var user = userService.findById(dto.getSender().getId());
        if (user == null) {
            throw new ApplicationException(ApplicationError.UserNotFound);
        }
        message.setSender(user);

        return message;
    }
}
