package com.mylib.cadastro.controller;

import com.mylib.cadastro.dto.CreateUserRoleDTO;
import com.mylib.cadastro.dto.UsuarioDto;
import com.mylib.cadastro.model.Usuario;
import com.mylib.cadastro.repository.UsuarioRepository;
import com.mylib.cadastro.service.CreateRoleUserService;
import com.mylib.cadastro.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository repository;
    private final UsuarioService service;

    private final CreateRoleUserService roleUserService;

    public UsuarioController(UsuarioRepository repository, UsuarioService service, CreateRoleUserService roleUserService) {
        this.repository = repository;
        this.service = service;
        this.roleUserService = roleUserService;
    }

    @GetMapping
    public List<?> listar() {
        return service.listUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<?> buscarPelaId(@PathVariable Integer id) {
        return repository.findById(id).map(UsuarioDto::transformaEmDTO);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody Usuario usuario) {
        service.criarUsuario(usuario);
    }

    @PostMapping("/role")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario role (@RequestBody CreateUserRoleDTO createUserRoleDTO) {
        return roleUserService.create(createUserRoleDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void atualizar(@PathVariable Integer id, @Valid @RequestBody Usuario usuario) {
        service.atualizar(id, usuario);
    }
}
