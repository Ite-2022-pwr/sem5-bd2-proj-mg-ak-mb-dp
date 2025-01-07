package pl.pwr.ite.bd2.service.impl;

import pl.pwr.ite.bd2.model.entity.MessageUserReceiverPair;
import pl.pwr.ite.bd2.model.repository.MessageUserReceiverPairRepository;
import pl.pwr.ite.bd2.service.MessageUserReceiverPairService;

public class MessageUserReceiverPairServiceImpl extends EntityServiceBase<MessageUserReceiverPair> implements MessageUserReceiverPairService {
    public MessageUserReceiverPairServiceImpl(MessageUserReceiverPairRepository repository) {
        super(repository);
    }
}
