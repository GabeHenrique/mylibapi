package com.mylib.cadastro.repository;

import com.mylib.cadastro.model.Produto;
import com.mylib.cadastro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
