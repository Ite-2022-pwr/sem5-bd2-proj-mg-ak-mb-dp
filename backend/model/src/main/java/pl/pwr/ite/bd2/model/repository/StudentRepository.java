package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.Student;
import pl.pwr.ite.bd2.model.filter.StudentFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

import java.util.logging.Filter;

public interface StudentRepository extends FilterableRepository<Student, StudentFilter> {
}
