package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
public class SecurityUser implements UserDetails {

    private Usuario usuario;

    @Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    // Asegúrate de que estás pasando el nombre del rol completo, con el prefijo "ROLE_"
    return usuario.getRoles().stream()
            .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
            .collect(Collectors.toList());
}

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getNombre(); // Se usa el nombre como username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}