package com.mylib.cadastro.controller;

import com.mylib.cadastro.dto.MovimentoEstoqueDto;
import com.mylib.cadastro.model.MovimentoEstoque;
import com.mylib.cadastro.service.MovimentoEstoqueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Movimento de Estoque")
@RequestMapping("/movimento-estoque")
@RequiredArgsConstructor
public class MovimentoEstoqueController {

    private final MovimentoEstoqueService service;

    @Operation(
        summary = "Listar todos os movimentos de estoque de um produto",
        description = "Retorna os movimentos de estoque de um produto"
    )
    @GetMapping("/listar/{IdProduto}")
    @ResponseStatus(HttpStatus.OK)
    public List<MovimentoEstoqueDto> listar(@PathVariable Integer IdProduto) {
        return service.listarPorIdProduto(IdProduto);
    }

    @Operation(
        summary = "Listar todos os movimentos de estoque",
        description = "Retorna todos os movimentos de estoque"
    )
    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<MovimentoEstoqueDto> listar() {
        return service.listar();
    }

    @Operation(
        summary = "Criar um movimento de estoque",
        description = "Cria um movimento de estoque"
    )
    @PostMapping("/criar/{idProduto}")
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody MovimentoEstoque movimentoEstoque, @PathVariable Integer idProduto) {
        service.criar(movimentoEstoque, idProduto);
    }
}
