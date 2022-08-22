package com.mylib.cadastro.model;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sg_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    public Role(Integer id) {
        this.id = id;
    }
}

