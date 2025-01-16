package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.ParentStudentPair;
import pl.pwr.ite.bd2.model.filter.ParentFilter;
import pl.pwr.ite.bd2.model.filter.ParentStudentPairFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

public interface ParentStudentPairRepository extends FilterableRepository <ParentStudentPair, ParentStudentPairFilter> {
}
