package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.QTeachersTeachingSubject;
import pl.pwr.ite.bd2.model.entity.TeachersTeachingSubject;
import pl.pwr.ite.bd2.model.filter.TeacherTeachingSubjectFilter;

@Component
public class TeacherTeachingSubjectFilterBinder extends FilterBinderBase<TeachersTeachingSubject, TeacherTeachingSubjectFilter, QTeachersTeachingSubject> {
}
