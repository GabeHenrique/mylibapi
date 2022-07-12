package com.mylib.config;

import com.mylib.cadastro.model.Usuario;
import com.mylib.cadastro.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario existsUser = usuarioRepository.findByEmail(email);
        if (existsUser == null) {
            throw new Error("Usuário não cadastrado");
        }
        return UserPrincipal.create(existsUser);
    }
}
