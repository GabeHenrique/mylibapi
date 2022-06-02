package com.mylib.cadastro.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sg_usuarios")
public class Usuario {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String senha;
    @NotNull
    @NotEmpty
    private String telefone;
    @NotNull
    @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
//    @Type(type = "java.sql.Blob")
    private Byte[] imagem;

}
