package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.SchoolSubject;
import pl.pwr.ite.bd2.model.filter.SchoolSubjectFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

public interface SchoolSubjectRepository extends FilterableRepository<SchoolSubject, SchoolSubjectFilter> {
}
