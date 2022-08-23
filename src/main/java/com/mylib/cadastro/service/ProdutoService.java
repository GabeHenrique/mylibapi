package com.mylib.cadastro.service;

import com.mylib.cadastro.dto.ProdutoDto;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final MovimentoEstoqueService movimentoEstoqueService;
    private final UsuarioService usuarioService;
    private final EmpresaService empresaService;

    public List<ProdutoDto> listar(Integer idUsuario) {
        var token = usuarioService.tokenEmpresa(idUsuario);
        return repository.findAllByEmpresaId(token).stream()
            .map(ProdutoDto::transformaEmDto)
            .collect(Collectors.toList());
    }

    public Optional<ProdutoDto> buscarPelaId(Integer id, Integer idUsuario) {
        var token = usuarioService.tokenEmpresa(idUsuario);
        return repository.findByIdAndEmpresaId(id, token).map(ProdutoDto::transformaEmDto);
    }

    public void criar(Produto produto, Integer idUsuario) {
        if (produto.getSaldoEstoque() != null) {
            var empresa = empresaService.buscarPelaId(usuarioService.tokenEmpresa(idUsuario)).orElseThrow();
            produto.setEmpresa(empresa);
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
        var produtoSalvo = repository.findById(id).orElse(null);
        if (produtoSalvo == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return produtoSalvo;
    }

    public void atualizar(Integer id, Produto produto) {
        var produtoSalvo = getProduto(id);
        BeanUtils.copyProperties(produto, produtoSalvo, "id");
        repository.save(produtoSalvo);
    }

    public void deletar(Integer id) {
        var produtoSalvo = getProduto(id);
        produtoSalvo.getMovimentos().forEach(movimento -> movimentoEstoqueService.delete(movimento.getId()));
        repository.delete(produtoSalvo);
    }
}
