package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.QTeacher;
import pl.pwr.ite.bd2.model.entity.Teacher;
import pl.pwr.ite.bd2.model.filter.TeacherFilter;

@Component
public class TeacherFilterBinder extends FilterBinderBase<Teacher, TeacherFilter, QTeacher> {
}
