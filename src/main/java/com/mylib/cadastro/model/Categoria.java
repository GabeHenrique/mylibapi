package com.mylib.cadastro.model;

import com.mylib.cadastro.entidade.Entidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cd_categoria")
public class Categoria implements Entidade<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer id;
    @Column(name = "nome")
    private String nome;


}
