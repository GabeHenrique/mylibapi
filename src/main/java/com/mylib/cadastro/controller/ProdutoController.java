package com.mylib.cadastro.controller;

import com.mylib.cadastro.model.Categoria;
import com.mylib.cadastro.model.Produto;
import com.mylib.cadastro.repository.CategoriaRepository;
import com.mylib.cadastro.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Produto> produtos = produtoRepository.findAll();
        return !produtos.isEmpty() ? ResponseEntity.ok(produtos) : ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPelaId(@PathVariable Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.isPresent() ? ResponseEntity.ok(produto) : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto, HttpServletResponse response) {
        Produto produtoSalvo = produtoRepository.save(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(produtoSalvo.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(produtoSalvo);
    }


}
