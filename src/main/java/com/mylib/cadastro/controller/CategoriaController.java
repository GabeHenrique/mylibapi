package com.mylib.cadastro.controller;

import com.mylib.cadastro.model.Categoria;
import com.mylib.cadastro.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public List<?> listar() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<?> buscarPelaId(@PathVariable Integer id) {
        return categoriaRepository.findById(id);
    }

    @PostMapping
    public void criar(@RequestBody Categoria categoria) {
        categoriaRepository.save(categoria);
    }


}
