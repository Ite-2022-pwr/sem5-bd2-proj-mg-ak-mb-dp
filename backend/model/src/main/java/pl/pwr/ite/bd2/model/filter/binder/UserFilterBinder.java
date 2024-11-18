package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.QUser;
import pl.pwr.ite.bd2.model.entity.User;
import pl.pwr.ite.bd2.model.filter.UserFilter;

@Component
public class UserFilterBinder extends FilterBinderBase<User, UserFilter, QUser> {
}
