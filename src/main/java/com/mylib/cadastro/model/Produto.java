package com.mylib.cadastro.model;


import com.mylib.cadastro.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cd_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    private Integer quantidade;
    @NotNull
    @NotEmpty
    @Column(name = "preco_fabrica")
    private Double precoFabrica;
    @NotNull
    @NotEmpty
    @Column(name = "preco_venda")
    private Double precoVenda;
    @NotNull
    @NotEmpty
    private String descricao;
    @NotNull
    @Column(name = "categoria")
    private Categoria categoria;
    @NotNull
    @Column(name = "considera_estoque")
    private Boolean consideraEstoque;
    @NotNull
    @Column(name = "ind_ativo")
    private Boolean ativo;

}
