package pl.pwr.ite.bd2.service;

import pl.pwr.ite.bd2.model.entity.Message;
import pl.pwr.ite.bd2.model.filter.MessageFilter;

public interface MessageService extends FilterableEntityService<Message, MessageFilter> {
}
