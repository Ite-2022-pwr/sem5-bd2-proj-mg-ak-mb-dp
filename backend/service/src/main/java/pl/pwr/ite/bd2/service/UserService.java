package pl.pwr.ite.bd2.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import pl.pwr.ite.bd2.model.entity.User;
import pl.pwr.ite.bd2.model.filter.UserFilter;

import java.util.Set;
import java.util.UUID;

public interface UserService extends UserDetailsService, FilterableEntityService<User, UserFilter> {

    boolean existsByEmail(String email);
    void collectAuthorities(User user, Set<GrantedAuthority> grantedAuthorities);
    User findByEmail(String email);

    boolean hasRoleByCodes(UUID userId, String... code);
    boolean hasAdminPanelAccess(UUID userId);
    User findByFirstAndLastName(String firstName, String secondName);
    User findByCode(String userCode);
    String generateCode(User user);
}
