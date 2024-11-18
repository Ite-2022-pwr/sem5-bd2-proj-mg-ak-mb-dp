package pl.pwr.ite.bd2.security.permission;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.UserRole;

import java.util.Set;

@Component
public class CoordinatorPermissionGranter extends PermissionGranterBase implements UserRolePermissionGranter {

    @Override
    public void handle(UserRole userRole, Set<GrantedAuthority> grantedAuthorities) {
        grantSystemAccess(grantedAuthorities);
    }
}
