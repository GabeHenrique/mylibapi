package com.mylib.cadastro.model;

import com.mylib.cadastro.enums.TipoMovimentacao;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eq_movimentacao")
public class MovimentoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movimentacao_id")
    private Integer id;
    @NotNull
    @Column(name = "tipo_movimentacao")
    private TipoMovimentacao tipoMovimentacao;
    @NotNull
    @Column(name = "quantidade")
    private Integer quantidade;
    @NotNull
    @Column(name = "data_movimentacao")
    private LocalDateTime dataMovimentacao = LocalDateTime.now();
    @NotNull
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

}
