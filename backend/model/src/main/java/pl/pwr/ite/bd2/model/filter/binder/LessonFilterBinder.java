package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;;
import pl.pwr.ite.bd2.model.entity.Lesson;
import pl.pwr.ite.bd2.model.entity.QLesson;
import pl.pwr.ite.bd2.model.filter.LessonFilter;

@Component
public class LessonFilterBinder extends FilterBinderBase<Lesson, LessonFilter, QLesson> {
}
