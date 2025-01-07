package pl.pwr.ite.bd2.service.impl;

import pl.pwr.ite.bd2.model.entity.Lesson;
import pl.pwr.ite.bd2.model.filter.LessonFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;
import pl.pwr.ite.bd2.model.repository.LessonRepository;
import pl.pwr.ite.bd2.service.LessonService;

public class LessonServiceImpl extends FilterableEntityServiceBase<Lesson, LessonFilter> implements LessonService {
    public LessonServiceImpl(LessonRepository repository) {
        super(repository);
    }
}
