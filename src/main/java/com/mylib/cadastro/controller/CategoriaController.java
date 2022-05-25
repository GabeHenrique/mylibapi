package com.mylib.cadastro.controller;

import com.mylib.cadastro.model.Categoria;
import com.mylib.cadastro.repository.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.repository = categoriaRepository;
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
    public void criar(@RequestBody Categoria categoria) {
        repository.save(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
