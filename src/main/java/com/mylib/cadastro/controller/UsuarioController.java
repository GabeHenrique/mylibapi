package com.mylib.cadastro.controller;

import com.mylib.cadastro.dto.CreateUserRoleDto;
import com.mylib.cadastro.dto.UsuarioDto;
import com.mylib.cadastro.model.Usuario;
import com.mylib.cadastro.service.CreateRoleUserService;
import com.mylib.cadastro.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(
        summary = "Permite listar os usuários",
        description = "É a listagem de usuários do sistema",
        tags = {"Usuario"}
    )
    @GetMapping
    public List<UsuarioDto> listar() {
        return service.listUsuarios();
    }

    @Operation(
        summary = "Permite buscar um usuário através do ID",
        description = "É a busca de um usuário através da ID",
        tags = {"Usuario"}
    )
    @GetMapping("/{id}")
    public Optional<UsuarioDto> buscarPelaId(@PathVariable Integer id) {
        return service.getPessoa(id).map(UsuarioDto::transformaEmDTO);
    }

    @Operation(
        summary = "Permite buscar um usuário através do email",
        description = "É a busca de um usuário através da email",
        tags = {"Usuario"}
    )
    @GetMapping("userInfo/{email}")
    public Optional<UsuarioDto> buscarPeloEmail(@PathVariable String email) {
        return service.getPessoaByEmail(email);
    }

    @Operation(
        summary = "Verifica se o usuário existe no sistema",
        description = "Retorna se o usuário está cadastrado no sistema",
        tags = {"Usuario"}
    )
    @PostMapping("/login")
    public Boolean exists(@RequestBody Usuario usuario) {
        return service.exists(usuario);
    }

    @Operation(
        summary = "Permite criar um novo usuário",
        description = "Permite realizar o cadastro de um novo usuário no sistema",
        tags = {"Usuario"}
    )
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody Usuario usuario) {
        service.criarUsuario(usuario);
    }

    @Operation(
        summary = "Permite criar uma nova ROLE",
        description = "Permite criar uma nova ROLE",
        tags = {"Usuario"}
    )
    @PostMapping("/role")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario role(@RequestBody CreateUserRoleDto createUserRoleDTO) {
        return roleUserService.create(createUserRoleDTO);
    }

    @Operation(
        summary = "Permite deletar um usuário do sistema",
        description = "Permite deletar um usuário do sistema",
        tags = {"Usuario"}
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.deletar(id);
    }

    @Operation(
        summary = "Permite atualizar um usuário do sistema",
        description = "Permite atualizar um usuário do sistema",
        tags = {"Usuario"}
    )
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void atualizar(@PathVariable Integer id, @Valid @RequestBody Usuario usuario) {
        service.atualizar(id, usuario);
    }
}
