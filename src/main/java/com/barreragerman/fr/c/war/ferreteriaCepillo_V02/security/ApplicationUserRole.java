package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.barreragerman.fr.c.war.ferreteriaCepillo_V02.security.ApplicationUSerPermission.CLIENTE_READ;
import static com.barreragerman.fr.c.war.ferreteriaCepillo_V02.security.ApplicationUSerPermission.CLIENTE_WRITE;

public enum ApplicationUserRole {
    OWNER(Sets.newHashSet(CLIENTE_WRITE,CLIENTE_READ)),
    ADMIN(Sets.newHashSet(CLIENTE_WRITE,CLIENTE_READ));

    private final Set<ApplicationUSerPermission> permissions;

    ApplicationUserRole(Set<ApplicationUSerPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUSerPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
