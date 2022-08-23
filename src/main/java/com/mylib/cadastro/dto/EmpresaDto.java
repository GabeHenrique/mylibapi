package com.mylib.cadastro.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mylib.cadastro.model.Usuario;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDto {

    private Integer id;
    private String nomeEmpresa;
    private String cnpj;
    @JsonIgnore
    private List<Usuario> usuarios;

}
