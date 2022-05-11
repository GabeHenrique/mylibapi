package com.mylib.cadastro.dto;

import com.mylib.ObjectUtils;
import com.mylib.cadastro.enums.NivelAcesso;
import com.mylib.cadastro.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDto {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private NivelAcesso nivelAcesso;

    public static UsuarioDto transformaEmDTO(Usuario usuario) {
        return ObjectUtils.convert(usuario, UsuarioDto.class);
    }
}
