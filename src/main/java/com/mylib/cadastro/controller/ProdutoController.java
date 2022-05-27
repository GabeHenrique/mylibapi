package com.mylib.cadastro.controller;

import com.mylib.cadastro.model.Produto;
import com.mylib.cadastro.repository.ProdutoRepository;
import com.mylib.cadastro.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoRepository repository;
    private final ProdutoService service;

    public ProdutoController(ProdutoRepository produtoRepository, ProdutoService produtoService) {
        this.repository = produtoRepository;
        this.service = produtoService;
    }

    @GetMapping
    public List<?> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<?> buscarPelaId(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody Produto produto) {
        repository.save(produto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void atualizar(@PathVariable Integer id, @Valid @RequestBody Produto produto) {
        service.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
