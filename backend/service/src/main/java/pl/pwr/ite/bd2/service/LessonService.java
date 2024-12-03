package pl.pwr.ite.bd2.service;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.Lesson;
import pl.pwr.ite.bd2.model.filter.LessonFilter;

public interface LessonService extends FilterableEntityService<Lesson, LessonFilter> {
}
