package com.mylib.cadastro.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

}
