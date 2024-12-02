package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.SchoolClass;
import pl.pwr.ite.bd2.model.filter.SchoolClassFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

public interface SchoolClassRepository extends FilterableRepository<SchoolClass, SchoolClassFilter> {
}
