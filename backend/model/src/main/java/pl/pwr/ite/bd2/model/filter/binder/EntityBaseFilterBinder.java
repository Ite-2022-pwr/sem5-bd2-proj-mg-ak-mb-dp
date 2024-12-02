package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.EntityBase;
import pl.pwr.ite.bd2.model.entity.QEntityBase;
import pl.pwr.ite.bd2.model.filter.EntityBaseFilter;

@Component
public class EntityBaseFilterBinder extends FilterBinderBase<EntityBase, EntityBaseFilter, QEntityBase> {
}
