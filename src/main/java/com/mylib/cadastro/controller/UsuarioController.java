package com.mylib.cadastro.controller;

import com.mylib.cadastro.model.Usuario;
import com.mylib.cadastro.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return !usuarios.isEmpty() ? ResponseEntity.ok(usuarios) : ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPelaId(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.isPresent() ? ResponseEntity.ok(usuario) : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario, HttpServletResponse response) {
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(usuarioSalvo.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(usuarioSalvo);
    }
}
