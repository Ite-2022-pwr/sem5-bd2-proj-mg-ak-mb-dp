package pl.pwr.ite.bd2.service;

import pl.pwr.ite.bd2.model.entity.EntityBase;
import pl.pwr.ite.bd2.model.filter.Filter;
import pl.pwr.ite.bd2.model.querydsl.TypedPage;

import java.util.List;

public interface FilterableEntityService<E extends EntityBase, F extends Filter> extends EntityService<E> {

    List<E> getList(F filter);

    TypedPage<E> getPage(F filter);
}
