package pl.pwr.ite.bd2.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.UserRole;
import pl.pwr.ite.bd2.model.filter.UserRoleFilter;
import pl.pwr.ite.bd2.model.repository.UserRoleRepository;
import pl.pwr.ite.bd2.service.UserRoleService;

@Service
public class UserRoleServiceImpl extends FilterableEntityServiceBase<UserRole, UserRoleFilter> implements UserRoleService {

    public UserRoleServiceImpl(UserRoleRepository repository) {
        super(repository);
    }
}
