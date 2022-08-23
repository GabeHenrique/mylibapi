package com.mylib.cadastro.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cd_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "empresa_id")
    private Integer id;
    @NotNull
    @NotEmpty
    @Column(name = "nome_empresa")
    private String nomeEmpresa;
    @Column(name = "cnpj")
    private String cnpj;
    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

}
