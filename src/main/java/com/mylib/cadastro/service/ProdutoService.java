package com.mylib.cadastro.service;

import com.mylib.cadastro.model.Produto;
import com.mylib.cadastro.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPelaId(Integer id) {
        return repository.findById(id);
    }

    public void criar(Produto produto) {
        repository.save(produto);
    }

    private Produto getProduto(Integer id) {
        Produto produtoSalvo = repository.findById(id).orElse(null);
        if (produtoSalvo == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return produtoSalvo;
    }

    public void atualizar(Integer id, Produto produto) {
        Produto produtoSalvo = getProduto(id);
        BeanUtils.copyProperties(produto, produtoSalvo, "id");
        repository.save(produtoSalvo);
    }

    public void deletar(Integer id) {
        Produto produtoSalvo = getProduto(id);
        repository.delete(produtoSalvo);
    }
}
