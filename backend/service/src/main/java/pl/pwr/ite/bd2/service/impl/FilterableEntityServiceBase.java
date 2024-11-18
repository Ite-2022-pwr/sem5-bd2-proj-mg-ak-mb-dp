package pl.pwr.ite.bd2.service.impl;

import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import pl.pwr.ite.bd2.model.entity.EntityBase;
import pl.pwr.ite.bd2.model.filter.Filter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;
import pl.pwr.ite.bd2.model.querydsl.TypedPage;
import pl.pwr.ite.bd2.service.FilterableEntityService;

import java.util.List;
import java.util.UUID;

public abstract class FilterableEntityServiceBase<E extends EntityBase, F extends Filter> extends EntityServiceBase<E> implements FilterableEntityService<E, F> {

    public FilterableEntityServiceBase(FilterableRepository<E, F> repository) {
        super(repository);
    }

    public FilterableRepository<E, F> getRepository() {
        return (FilterableRepository<E, F>) super.getRepository();
    }

    @Override
    public List<E> getList(F filter) {
        return getRepository().findAll(filter);
    }

    @Override
    public TypedPage<E> getPage(F filter) {
        return getRepository().findPage(filter);
    }

    @Override
    public JPAQuery<?> createQuery() {
        return new JPAQuery<>(getEntityManager());
    }

    @Override
    public EntityManager getEntityManager() {
        return getRepository().getEntityManager();
    }

    @Override
    public void delete(E entity) {
        getRepository().delete(entity);
    }

    @Override
    public void deleteById(UUID id) {
        getRepository().deleteById(id);
    }
}
