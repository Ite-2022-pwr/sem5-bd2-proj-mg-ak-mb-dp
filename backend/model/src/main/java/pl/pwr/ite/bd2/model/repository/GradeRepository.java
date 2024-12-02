package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.Grade;
import pl.pwr.ite.bd2.model.filter.GradeFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

public interface GradeRepository extends FilterableRepository<Grade, GradeFilter> {
}
