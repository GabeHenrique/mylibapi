package com.mylib.cadastro.dto;


import com.mylib.ObjectUtils;
import com.mylib.cadastro.enums.Categoria;
import com.mylib.cadastro.model.Produto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

    private Integer id;
    private String nome;
    private Integer saldoEstoque = 0;
    private Double precoFabrica;
    private Double precoVenda;
    private String descricao;
    private Categoria categoria;
    private Boolean ativo;
    private String empresaId;

    public static ProdutoDto transformaEmDto(Produto produto) {
        return ObjectUtils.convert(produto, ProdutoDto.class);
    }

}
