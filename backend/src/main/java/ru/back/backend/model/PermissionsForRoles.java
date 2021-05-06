package ru.back.backend.model;

public enum PermissionsForRoles {//сами полномочия,которые можно дать ролям

    //interactions
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    //administrative* (for admins only),никакого функционала пока-что
    USER_BAN("user:ban"),
    USER_DELETE("user:delete");

    private final String permission;

    PermissionsForRoles(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
