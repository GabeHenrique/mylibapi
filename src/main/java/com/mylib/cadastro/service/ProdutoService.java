package com.mylib.cadastro.service;

import com.mylib.cadastro.model.Produto;
import com.mylib.cadastro.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
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

}
