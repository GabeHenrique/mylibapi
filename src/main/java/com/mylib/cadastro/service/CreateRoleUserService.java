package com.mylib.cadastro.service;

import com.mylib.cadastro.dto.CreateUserRoleDto;
import com.mylib.cadastro.model.Role;
import com.mylib.cadastro.model.Usuario;
import com.mylib.cadastro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreateRoleUserService {

    private final UsuarioRepository repository;

    public CreateRoleUserService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario create(CreateUserRoleDto createUserRoleDTO) {

        Optional<Usuario> userExists = repository.findById(createUserRoleDTO.getIdUser());
        List<Role> roles;
        if (userExists.isEmpty()) {
            throw new Error("User does not exists!");
        }
        roles = createUserRoleDTO.getIdsRoles().stream().map(Role::new).collect(Collectors.toList());
        Usuario usuario = userExists.get();
        usuario.setRoles(roles);
        repository.save(usuario);
        return usuario;
    }
}