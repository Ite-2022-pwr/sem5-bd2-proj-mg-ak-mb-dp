package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.QSchoolClass;
import pl.pwr.ite.bd2.model.entity.SchoolClass;
import pl.pwr.ite.bd2.model.filter.SchoolClassFilter;

@Component
public class SchoolClassFilterBinder extends FilterBinderBase<SchoolClass, SchoolClassFilter, QSchoolClass> {
}
