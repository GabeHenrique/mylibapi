package com.mylib.cadastro.dto;

import com.mylib.ObjectUtils;
import com.mylib.cadastro.model.Role;
import com.mylib.cadastro.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDto {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private List<Role> roles;
    private Blob imagem;

    public static UsuarioDto transformaEmDTO(Usuario usuario) {
        return ObjectUtils.convert(usuario, UsuarioDto.class);
    }
}
