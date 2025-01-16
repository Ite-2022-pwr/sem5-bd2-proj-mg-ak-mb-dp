package pl.pwr.ite.bd2.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.Lesson;
import pl.pwr.ite.bd2.model.filter.LessonFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;
import pl.pwr.ite.bd2.service.LessonService;

@Service
public class LessonServiceImpl extends FilterableEntityServiceBase<Lesson, LessonFilter> implements LessonService {
    public LessonServiceImpl(FilterableRepository<Lesson, LessonFilter> repository) {
        super(repository);
    }
}
