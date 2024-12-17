package pl.pwr.ite.bd2.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.Message;
import pl.pwr.ite.bd2.model.filter.MessageFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;
import pl.pwr.ite.bd2.model.repository.MessageRepository;
import pl.pwr.ite.bd2.service.MessageService;

@Service
public class MessageServiceImpl extends FilterableEntityServiceBase<Message, MessageFilter> implements MessageService {

    public MessageServiceImpl(MessageRepository repository) {
        super(repository);
    }
}
