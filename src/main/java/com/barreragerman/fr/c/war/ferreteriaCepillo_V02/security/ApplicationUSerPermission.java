package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.security;

public enum ApplicationUSerPermission {

    CLIENTE_READ("cliente:read"),
    CLIENTE_WRITE("cliente:write");

    private final String permission;

    ApplicationUSerPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
