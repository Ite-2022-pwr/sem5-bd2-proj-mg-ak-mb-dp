package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.QStudent;
import pl.pwr.ite.bd2.model.entity.Student;
import pl.pwr.ite.bd2.model.filter.StudentFilter;

@Component
public class StudentFilterBinder extends FilterBinderBase<Student, StudentFilter, QStudent> {
}
