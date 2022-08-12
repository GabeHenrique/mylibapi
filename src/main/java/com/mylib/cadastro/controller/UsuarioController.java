package com.mylib.cadastro.controller;

import com.mylib.cadastro.dto.CreateUserRoleDto;
import com.mylib.cadastro.dto.UsuarioDto;
import com.mylib.cadastro.model.Usuario;
import com.mylib.cadastro.service.CreateRoleUserService;
import com.mylib.cadastro.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final CreateRoleUserService roleUserService;

    @GetMapping
    public List<UsuarioDto> listar() {
        return service.listUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<UsuarioDto> buscarPelaId(@PathVariable Integer id) {
        return service.getPessoa(id).map(UsuarioDto::transformaEmDTO);
    }

    @GetMapping("userInfo/{email}")
    public Optional<UsuarioDto> buscarPeloEmail(@PathVariable String email) {
        return service.getPessoaByEmail(email);
    }

    @PostMapping("/login")
    public Boolean exists(@RequestBody Usuario usuario) {
        return service.exists(usuario);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody Usuario usuario) {
        service.criarUsuario(usuario);
    }

    @PostMapping("/role")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario role(@RequestBody CreateUserRoleDto createUserRoleDTO) {
        return roleUserService.create(createUserRoleDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.deletar(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void atualizar(@PathVariable Integer id, @Valid @RequestBody Usuario usuario) {
        service.atualizar(id, usuario);
    }
}
