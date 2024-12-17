package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.Message;
import pl.pwr.ite.bd2.model.entity.QMessage;
import pl.pwr.ite.bd2.model.filter.MessageFilter;

@Component
public class MessageFilterBinder extends FilterBinderBase<Message, MessageFilter, QMessage> {
}
