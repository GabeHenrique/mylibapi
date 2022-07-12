package com.mylib.cadastro.service;

import com.mylib.cadastro.dto.UsuarioDto;
import com.mylib.cadastro.model.Usuario;
import com.mylib.cadastro.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    private Usuario getPessoa(Integer id) {
        Usuario pessoaSalva = repository.findById(id).orElse(null);
        if (pessoaSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return pessoaSalva;
    }

    public void criarUsuario(Usuario usuario) {
        if (repository.findByEmail(usuario.getEmail()) != null) {
            throw new Error("Usuário já cadastrado");
        }
        usuario.setSenha(passwordEncoder().encode(usuario.getSenha()));
        repository.save(usuario);
    }

    public void atualizar(Integer id, Usuario usuario) {
        Usuario usuarioSalvo = getPessoa(id);
        BeanUtils.copyProperties(usuario, usuarioSalvo, "id");
        usuarioSalvo.setSenha(passwordEncoder().encode(usuario.getSenha()));
        repository.save(usuarioSalvo);
    }

    public List<?> listUsuarios() {
        return repository.findAll().stream().map(UsuarioDto::transformaEmDTO).collect(Collectors.toList());
    }
}
