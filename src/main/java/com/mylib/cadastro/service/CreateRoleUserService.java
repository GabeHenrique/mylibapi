package com.mylib.cadastro.service;

import com.mylib.cadastro.dto.CreateUserRoleDto;
import com.mylib.cadastro.model.Role;
import com.mylib.cadastro.model.Usuario;
import com.mylib.cadastro.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreateRoleUserService {

    private final UsuarioRepository repository;

    public Usuario create(CreateUserRoleDto createUserRoleDTO) {
        var userExists = repository.findById(createUserRoleDTO.getIdUser());
        if (userExists.isEmpty()) {
            throw new Error("User does not exists!");
        }
        var roles = createUserRoleDTO.getIdsRoles().stream().map(Role::new).collect(Collectors.toList());
        var usuario = userExists.get();
        usuario.setRoles(roles);
        repository.save(usuario);
        return usuario;
    }
}