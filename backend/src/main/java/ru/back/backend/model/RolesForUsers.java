package ru.back.backend.model;
//Imports
//Security
import org.springframework.security.core.authority.SimpleGrantedAuthority;

//Vanilla Java
import java.util.Set;
import java.util.stream.Collectors;

public enum RolesForUsers {//описание всех ролей,полномочия ролей
    //Админ//писать,читать,банить*,удалять*  *=>(на всякий случай)
    ADMIN(Set.of(PermissionsForRoles.USER_WRITE, PermissionsForRoles.USER_READ, PermissionsForRoles.USER_BAN, PermissionsForRoles.USER_DELETE)),
    //Обычный человек
    USER(Set.of(PermissionsForRoles.USER_READ));

    public final Set<PermissionsForRoles> permissions;

    RolesForUsers(Set<PermissionsForRoles> permissions) {
        this.permissions = permissions;
    }

    public Set<PermissionsForRoles> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }

}
