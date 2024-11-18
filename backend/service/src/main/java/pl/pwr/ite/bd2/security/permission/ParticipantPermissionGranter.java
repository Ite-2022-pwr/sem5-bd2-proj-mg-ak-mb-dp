package pl.pwr.ite.bd2.security.permission;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.UserRole;
import pl.pwr.ite.bd2.model.enums.Permission;

import java.util.Set;

@Component
public class ParticipantPermissionGranter extends PermissionGranterBase implements UserRolePermissionGranter{

    @Override
    public void handle(UserRole userRole, Set<GrantedAuthority> grantedAuthorities) {
        grant(grantedAuthorities, new PermissionAuthority(Permission.SystemView));
    }
}
