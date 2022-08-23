package com.mylib.cadastro.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mylib.cadastro.enums.Categoria;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cd_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Integer id;
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @PositiveOrZero
    @Column(name = "saldo_estoque")
    private Integer saldoEstoque = 0;
    @NotNull
    @Column(name = "preco_fabrica")
    private Double precoFabrica;
    @NotNull
    @Column(name = "preco_venda")
    private Double precoVenda;
    @NotNull
    @NotEmpty
    @Column(name = "descricao")
    private String descricao;
    @NotNull
    @Column(name = "categoria")
    private Categoria categoria;
    @NotNull
    @Column(name = "ind_ativo")
    private Boolean ativo;
    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    private List<MovimentoEstoque> movimentos;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

}
