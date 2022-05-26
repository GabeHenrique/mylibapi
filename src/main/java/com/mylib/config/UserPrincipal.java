package com.mylib.config;

import com.mylib.cadastro.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private final String email;
    private final String senha;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Usuario usuario) {
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        List<SimpleGrantedAuthority> authorities;
        authorities = usuario.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_".concat(role.getNome()))).collect(Collectors.toList());
        this.authorities = authorities;
    }

    public static UserPrincipal create(Usuario usuario) {
        return new UserPrincipal(usuario);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
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
