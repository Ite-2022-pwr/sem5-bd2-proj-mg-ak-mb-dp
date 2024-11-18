package pl.pwr.ite.bd2.service;

import pl.pwr.ite.bd2.model.enums.Permission;
import pl.pwr.ite.bd2.security.permission.PermissionAuthority;

import java.util.Collection;

public interface PermissionService {

    boolean hasAccess(Permission permission, Collection<PermissionAuthority> authorities);
}
