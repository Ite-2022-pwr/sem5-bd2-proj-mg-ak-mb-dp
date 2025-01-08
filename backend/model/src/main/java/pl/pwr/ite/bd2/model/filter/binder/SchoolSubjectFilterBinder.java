package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.QSchoolSubject;
import pl.pwr.ite.bd2.model.entity.SchoolSubject;
import pl.pwr.ite.bd2.model.filter.SchoolSubjectFilter;

@Component
public class SchoolSubjectFilterBinder extends FilterBinderBase<SchoolSubject, SchoolSubjectFilter, QSchoolSubject> {
}
