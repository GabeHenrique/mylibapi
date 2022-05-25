package com.mylib.cadastro.controller;

import com.mylib.cadastro.model.Produto;
import com.mylib.cadastro.model.Usuario;
import com.mylib.cadastro.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.repository = produtoRepository;
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
    public void criar(@RequestBody Produto produto) {
        repository.save(produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
