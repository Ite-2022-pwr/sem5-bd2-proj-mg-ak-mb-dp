package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.QUserRole;
import pl.pwr.ite.bd2.model.entity.UserRole;
import pl.pwr.ite.bd2.model.filter.UserRoleFilter;

@Component
public class UserRoleFilterBinder extends FilterBinderBase<UserRole, UserRoleFilter, QUserRole> {
}
