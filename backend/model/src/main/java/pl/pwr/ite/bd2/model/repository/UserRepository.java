package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.User;
import pl.pwr.ite.bd2.model.filter.UserFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

public interface UserRepository extends FilterableRepository<User, UserFilter> {
}
