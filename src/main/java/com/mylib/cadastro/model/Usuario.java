package com.mylib.cadastro.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sg_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer id;
    @NotNull
    @NotEmpty
    @Column(name = "nome")
    private String nome;
    @NotNull
    @NotEmpty
    @Column(name = "email")
    private String email;
    @NotNull
    @NotEmpty
    @Column(name = "senha")
    private String senha;
    @NotNull
    @NotEmpty
    @Column(name = "cpf")
    private String telefone;
    @NotNull
    @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
