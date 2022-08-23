package com.mylib.cadastro.controller;

import com.mylib.cadastro.dto.ProdutoDto;
import com.mylib.cadastro.dto.ProdutoEstoqueDto;
import com.mylib.cadastro.model.Produto;
import com.mylib.cadastro.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Tag(name = "Produto")
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @Operation(
        summary = "Permite listar todos os produtos",
        description = "É a listagem de todos os produtos"
    )
    @GetMapping
    public List<ProdutoDto> listar(@RequestParam Integer idUsuario) {
        return service.listar(idUsuario);
    }

    @Operation(
        summary = "Permite listar os produtos para a tela de estoque",
        description = "É a busca de produtos para a tela de estoque",
        tags = {"Movimento de Estoque"}
    )
    @GetMapping("/tela-estoque")
    public List<ProdutoEstoqueDto> listarTelaEstoque(@RequestParam Integer idUsuario) {
        return service.listar(idUsuario).stream().map(ProdutoEstoqueDto::dtoToDto).collect(Collectors.toList());
    }

    @Operation(
        summary = "Permite buscar um produto por Id",
        description = "É a busca de um produto por Id"
    )
    @GetMapping("/{id}")
    public Optional<ProdutoDto> buscarPelaId(@PathVariable Integer id, @RequestParam Integer idUsuario) {
        return service.buscarPelaId(id, idUsuario);
    }

    @Operation(
        summary = "Permite criar um produto",
        description = "É a criação de um novo produto"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody @Valid Produto produto, @RequestParam Integer idUsuario) {
        service.criar(produto, idUsuario);
    }

    @Operation(
        summary = "Permite atualizar um produto",
        description = "É a atualização de um produto"
    )
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void atualizar(@PathVariable Integer id, @Valid @RequestBody Produto produto) {
        service.atualizar(id, produto);
    }

    @Operation(
        summary = "Permite deletar um produto",
        description = "É a exclusão de um produto"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.deletar(id);
    }
}
