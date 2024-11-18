package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.UserRole;
import pl.pwr.ite.bd2.model.filter.UserRoleFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

public interface UserRoleRepository extends FilterableRepository<UserRole, UserRoleFilter> {
}
