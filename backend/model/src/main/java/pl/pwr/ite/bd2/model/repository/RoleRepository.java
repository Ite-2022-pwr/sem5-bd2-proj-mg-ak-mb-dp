package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.Role;
import pl.pwr.ite.bd2.model.filter.RoleFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

public interface RoleRepository extends FilterableRepository<Role, RoleFilter> {
}
