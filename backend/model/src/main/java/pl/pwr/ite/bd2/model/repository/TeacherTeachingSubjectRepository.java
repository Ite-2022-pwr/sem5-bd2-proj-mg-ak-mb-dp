package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.TeachersTeachingSubject;
import pl.pwr.ite.bd2.model.filter.TeacherTeachingSubjectFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

public interface TeacherTeachingSubjectRepository extends FilterableRepository<TeachersTeachingSubject, TeacherTeachingSubjectFilter> {
}
