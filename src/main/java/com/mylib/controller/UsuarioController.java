package com.mylib.controller;

import com.mylib.model.Usuario;
import com.mylib.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return !usuarios.isEmpty() ? ResponseEntity.ok(usuarios) : ResponseEntity.noContent().build();
    }

}
