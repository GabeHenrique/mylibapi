package com.mylib.cadastro.repository;

import com.mylib.cadastro.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findAllByEmpresaId(Integer id);

    Optional<Produto> findByIdAndEmpresaId(Integer id, Integer empresaId);

}
