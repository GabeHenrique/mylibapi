package com.mylib.cadastro.service;

import com.mylib.cadastro.dto.UsuarioDto;
import com.mylib.cadastro.model.Usuario;
import com.mylib.cadastro.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public Optional<Usuario> getPessoa(Integer id) {
        return repository.findById(id);
    }

    public Optional<UsuarioDto> getPessoaByEmail(String email) {
        Integer pessoaId = repository.findByEmail(email).getId();
        return repository.findById(pessoaId).map(UsuarioDto::transformaEmDTO);
    }

    public Boolean exists(Usuario usuario) {
        Usuario usuarioFind = repository.findByEmail(usuario.getEmail());
        var validaSenha = passwordEncoder().matches(usuario.getSenha(), usuarioFind.getSenha());
        if (usuarioFind == null || !validaSenha) {
            throw new IllegalArgumentException("Usuário ou senha inválida");
        }
        return validaSenha;
    }

    @ApiIgnore
    public Integer tokenEmpresa(Integer idUsuario) {
        return repository.findById(idUsuario).orElseThrow().getEmpresa().getId();
    }

    public void criarUsuario(Usuario usuario) {
        if (repository.findByEmail(usuario.getEmail()) != null) {
            throw new Error("Usuário já cadastrado");
        } else {
            usuario.setSenha(passwordEncoder().encode(usuario.getSenha()));
            repository.save(usuario);
        }
    }

    public void atualizar(Integer id, Usuario usuario) {
        var usuarioSalvo = getPessoa(id).orElseThrow();
        BeanUtils.copyProperties(usuario, usuarioSalvo, "id");
        usuarioSalvo.setSenha(passwordEncoder().encode(usuario.getSenha()));
        repository.save(usuarioSalvo);
    }

    public List<UsuarioDto> listUsuarios() {
        return repository.findAll().stream().map(UsuarioDto::transformaEmDTO).collect(Collectors.toList());
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
