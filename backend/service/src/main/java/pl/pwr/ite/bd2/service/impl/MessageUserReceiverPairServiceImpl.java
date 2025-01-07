package pl.pwr.ite.bd2.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.MessageUserReceiverPair;
import pl.pwr.ite.bd2.model.repository.MessageUserReceiverPairRepository;
import pl.pwr.ite.bd2.service.MessageUserReceiverPairService;

@Service
public class MessageUserReceiverPairServiceImpl extends EntityServiceBase<MessageUserReceiverPair> implements MessageUserReceiverPairService {
    public MessageUserReceiverPairServiceImpl(MessageUserReceiverPairRepository repository) {
        super(repository);
    }
}
