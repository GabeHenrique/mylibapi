package com.mylib.cadastro.controller;

import com.mylib.cadastro.model.Carrinho;
import com.mylib.cadastro.repository.CarrinhoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoRepository repository;


    public CarrinhoController(CarrinhoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPelaId(@PathVariable Integer id) {
        Optional<Carrinho> carrinho = repository.findById(id);
        return carrinho.isPresent() ? ResponseEntity.ok(carrinho) : ResponseEntity.noContent().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody Carrinho carrinho) {
        Carrinho carrinhoSalvo = Carrinho.builder().produtos(carrinho.getProdutos()).dataDeVenda(LocalDateTime.now()).build();
        repository.save(carrinhoSalvo);
    }
}
