package com.mylib.cadastro.dto;

import com.mylib.ObjectUtils;
import com.mylib.cadastro.enums.TipoMovimentacao;
import com.mylib.cadastro.model.MovimentoEstoque;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class MovimentoEstoqueDto {

    private Integer id;
    private TipoMovimentacao tipoMovimentacao;
    private Integer quantidade;
    private LocalDateTime dataMovimentacao;
    private Integer produtoId;
    private String produtoNome;

    public static MovimentoEstoqueDto transformaEmDTO(MovimentoEstoque movimentoEstoque) {
        return ObjectUtils.convert(movimentoEstoque, MovimentoEstoqueDto.class);
    }
}
