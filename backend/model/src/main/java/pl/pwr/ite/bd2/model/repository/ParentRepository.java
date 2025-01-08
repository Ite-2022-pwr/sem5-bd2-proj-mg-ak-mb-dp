package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.Parent;
import pl.pwr.ite.bd2.model.filter.ParentFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

public interface ParentRepository extends FilterableRepository<Parent, ParentFilter> {
}
