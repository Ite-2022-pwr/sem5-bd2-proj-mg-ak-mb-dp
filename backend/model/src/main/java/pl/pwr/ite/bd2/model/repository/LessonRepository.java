package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.Lesson;
import pl.pwr.ite.bd2.model.filter.LessonFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

public interface LessonRepository extends FilterableRepository<Lesson, LessonFilter> {
}
