package pl.pwr.ite.bd2.service;

import pl.pwr.ite.bd2.model.entity.Role;
import pl.pwr.ite.bd2.model.filter.RoleFilter;

public interface RoleService extends FilterableEntityService<Role, RoleFilter> {

    Role findByCode(String name);
}
