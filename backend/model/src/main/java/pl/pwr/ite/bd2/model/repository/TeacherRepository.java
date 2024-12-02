package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.Teacher;
import pl.pwr.ite.bd2.model.filter.TeacherFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

import java.io.FilterReader;

public interface TeacherRepository extends FilterableRepository<Teacher, TeacherFilter> {
}
