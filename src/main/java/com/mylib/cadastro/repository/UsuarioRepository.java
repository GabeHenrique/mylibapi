package com.mylib.cadastro.repository;

import com.mylib.cadastro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmail(String email);

    Optional<Usuario> findById(Integer idUser);

    @Query("SELECT u from Usuario u JOIN FETCH u.roles where u.email = :email")
    Usuario findByEmailFetchRoles(@Param("email") String email);

}
