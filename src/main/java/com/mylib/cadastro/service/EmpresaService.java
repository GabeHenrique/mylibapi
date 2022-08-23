package com.mylib.cadastro.service;

import com.mylib.cadastro.model.Empresa;
import com.mylib.cadastro.repository.EmpresaRepository;
import com.mylib.cadastro.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository repository;
    private final UsuarioRepository usuarioRepository;

    public Integer criarEmpresa(Empresa empresa) {
        return repository.save(empresa).getId();
    }

    public Optional<Empresa> buscarPelaId(Integer id) {
        return repository.findById(id);
    }

    public void associarUsuario(Integer empresaId, Integer usuarioId) {
        var empresa = repository.findById(empresaId);
        var usuario = usuarioRepository.findById(usuarioId).orElseThrow();
        empresa.ifPresent(emp -> emp.getUsuarios().add(usuario));
        repository.save(empresa.orElseThrow());
    }
}
