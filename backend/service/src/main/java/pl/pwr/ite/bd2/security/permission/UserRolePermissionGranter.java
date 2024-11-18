package pl.pwr.ite.bd2.security.permission;

import org.springframework.security.core.GrantedAuthority;
import pl.pwr.ite.bd2.model.entity.UserRole;

import java.util.Set;

public interface UserRolePermissionGranter extends PermissionGranter {

    void handle(UserRole userRole, Set<GrantedAuthority> grantedAuthorities);
}
