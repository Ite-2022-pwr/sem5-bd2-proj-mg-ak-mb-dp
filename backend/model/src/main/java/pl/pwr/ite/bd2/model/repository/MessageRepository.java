package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.Message;
import pl.pwr.ite.bd2.model.filter.MessageFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

public interface MessageRepository extends FilterableRepository<Message, MessageFilter> {
}
