package com.mylib.cadastro.controller;

import com.mylib.cadastro.model.Empresa;
import com.mylib.cadastro.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Tag(name = "Empresa")
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService service;

    @Operation(
        summary = "Permite criar uma empresa",
        description = "É a criação de uma empresa"
    )
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer criarEmpresa(@RequestBody @Valid Empresa empresa) {
        return service.criarEmpresa(empresa);
    }

    @Operation(
        summary = "Permite buscar uma empresa por ID",
        description = "É a busca de uma empresa por ID"
    )
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Empresa> buscarPelaId(@PathVariable Integer id) {
        return service.buscarPelaId(id);
    }

    @Operation(
        summary = "Permite associar uma empresa a um usuário",
        description = "É a associacao de uma empresa a um usuário"
    )
    @PutMapping("/{empresaId}/{usuarioId}")
    @ResponseStatus(HttpStatus.OK)
    public void associarUsuario(@PathVariable Integer empresaId, @PathVariable Integer usuarioId) {
        service.associarUsuario(empresaId, usuarioId);
    }
}
