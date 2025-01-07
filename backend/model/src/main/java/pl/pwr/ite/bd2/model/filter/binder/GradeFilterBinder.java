package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.Grade;
import pl.pwr.ite.bd2.model.entity.QGrade;
import pl.pwr.ite.bd2.model.filter.GradeFilter;

@Component
public class GradeFilterBinder extends FilterBinderBase<Grade, GradeFilter, QGrade> {
}
