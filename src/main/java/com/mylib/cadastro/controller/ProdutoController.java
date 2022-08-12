package com.mylib.cadastro.controller;

import com.mylib.cadastro.model.Produto;
import com.mylib.cadastro.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarPelaId(@PathVariable Integer id) {
        return service.buscarPelaId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody @Valid Produto produto) {
        service.criar(produto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void atualizar(@PathVariable Integer id, @Valid @RequestBody Produto produto) {
        service.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.deletar(id);
    }

}
