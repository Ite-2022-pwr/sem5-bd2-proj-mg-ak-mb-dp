package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.QRole;
import pl.pwr.ite.bd2.model.entity.Role;
import pl.pwr.ite.bd2.model.filter.RoleFilter;

@Component
public class RoleFilterBinder extends FilterBinderBase<Role, RoleFilter, QRole> {
}
