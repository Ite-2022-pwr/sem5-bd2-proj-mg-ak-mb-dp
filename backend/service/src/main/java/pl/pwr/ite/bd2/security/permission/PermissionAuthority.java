package pl.pwr.ite.bd2.security.permission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import pl.pwr.ite.bd2.model.enums.Permission;

public class PermissionAuthority implements GrantedAuthority {

    protected final Permission permission;

    public PermissionAuthority(Permission permission) {
        this.permission = permission;
    }

    @JsonIgnore
    @Override
    public String getAuthority() {
        return permission.name();
    }

    @Override
    public int hashCode() {
        return this.permission.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj instanceof PermissionAuthority permissionAuthority) {
            return getAuthority().equals(permissionAuthority.getAuthority());
        }
        return false;
    }

    @Override
    public String toString() {
        return getAuthority();
    }
}
