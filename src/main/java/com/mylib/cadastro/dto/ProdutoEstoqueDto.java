package com.mylib.cadastro.dto;

import com.mylib.ObjectUtils;
import com.mylib.cadastro.model.Produto;
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

    public static ProdutoEstoqueDto transformaEmDTO(Produto produto) {
        return ObjectUtils.convert(produto, ProdutoEstoqueDto.class);
    }

}
