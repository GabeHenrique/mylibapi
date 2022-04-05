package com.mylib.cadastro.model;

import com.mylib.cadastro.controller.CategoriaController;
import com.mylib.cadastro.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cd_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Integer id;
    @Column(name = "nome")
    private String nome;

}
