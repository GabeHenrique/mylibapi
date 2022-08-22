package com.mylib.cadastro.repository;

import com.mylib.cadastro.model.MovimentoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimentoEstoqueRepository extends JpaRepository<MovimentoEstoque, Integer> {

    List<MovimentoEstoque> findAllByProdutoId(Integer id);
}
