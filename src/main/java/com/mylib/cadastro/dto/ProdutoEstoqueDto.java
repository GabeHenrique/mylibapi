package com.mylib.cadastro.dto;

import com.mylib.ObjectUtils;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ProdutoEstoqueDto {

    private Integer id;
    private String nome;
    private Integer saldoEstoque;

    public static ProdutoEstoqueDto dtoToDto(ProdutoDto dto) {
        return ObjectUtils.convert(dto, ProdutoEstoqueDto.class);
    }

}
