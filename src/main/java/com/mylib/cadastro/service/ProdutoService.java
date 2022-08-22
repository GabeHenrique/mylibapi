package com.mylib.cadastro.service;

import com.mylib.cadastro.enums.TipoMovimentacao;
import com.mylib.cadastro.model.MovimentoEstoque;
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
    private final MovimentoEstoqueService movimentoEstoqueService;

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPelaId(Integer id) {
        return repository.findById(id);
    }

    public void criar(Produto produto) {
        if (produto.getSaldoEstoque() != null) {
            repository.save(produto);
            var movimento = new MovimentoEstoque();
            movimento.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
            movimento.setQuantidade(produto.getSaldoEstoque());
            produto.setSaldoEstoque(0);
            movimentoEstoqueService.criar(movimento, produto.getId());
        }
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
        produtoSalvo.getMovimentos().forEach(movimento -> movimentoEstoqueService.delete(movimento.getId()));
        repository.delete(produtoSalvo);
    }
}
