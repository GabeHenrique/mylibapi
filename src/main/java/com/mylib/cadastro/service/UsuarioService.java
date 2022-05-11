package com.mylib.cadastro.service;

import com.mylib.cadastro.dto.UsuarioDto;
import com.mylib.cadastro.model.Usuario;
import com.mylib.cadastro.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    private Usuario getPessoa(Integer id) {
        Usuario pessoaSalva = repository.findById(id).orElse(null);
        if (pessoaSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return pessoaSalva;
    }

    public void atualizar(Integer id, Usuario usuario) {
        Usuario usuarioSalvo = getPessoa(id);
        BeanUtils.copyProperties(usuario, usuarioSalvo, "id");
        repository.save(usuarioSalvo);
    }

    public List<?> listUsuarios() {
        return repository.findAll().stream().map(UsuarioDto::transformaEmDTO).collect(Collectors.toList());
    }

    public UsuarioDto toUsuarioDto(Usuario usuario) {
        return new UsuarioDto(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone(), usuario.getNivelAcesso());
    }
}
