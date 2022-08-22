package com.mylib.cadastro.service;

import com.mylib.cadastro.dto.MovimentoEstoqueDto;
import com.mylib.cadastro.model.MovimentoEstoque;
import com.mylib.cadastro.repository.MovimentoEstoqueRepository;
import com.mylib.cadastro.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovimentoEstoqueService {

    private final ProdutoRepository produtoRepository;
    private final MovimentoEstoqueRepository repository;

    public void criar(MovimentoEstoque movimentoEstoque, Integer idProduto) {
        var produto = produtoRepository.findById(idProduto).orElseThrow();
        switch (movimentoEstoque.getTipoMovimentacao()) {
            case ENTRADA:
                produto.setSaldoEstoque(produto.getSaldoEstoque() + movimentoEstoque.getQuantidade());
                break;
            case SAIDA:
                produto.setSaldoEstoque(produto.getSaldoEstoque() - movimentoEstoque.getQuantidade());
                break;
        }
        produtoRepository.save(produto);
        movimentoEstoque.setProduto(produto);
        repository.save(movimentoEstoque);
    }

    public List<MovimentoEstoqueDto> listarPorIdProduto(Integer idProduto) {
        return repository.findAllByProdutoId(idProduto).stream().map(MovimentoEstoqueDto::transformaEmDTO).collect(Collectors.toList());
    }

    public List<MovimentoEstoqueDto> listar() {
        return repository.findAll().stream().map(MovimentoEstoqueDto::transformaEmDTO).collect(Collectors.toList());
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
