package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.Parent;
import pl.pwr.ite.bd2.model.entity.QParent;
import pl.pwr.ite.bd2.model.filter.ParentFilter;

@Component
public class ParentFilterBinder extends FilterBinderBase<Parent, ParentFilter, QParent> {
}
