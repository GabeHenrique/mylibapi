package com.mylib.cadastro.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRoleDto {

    private Integer idUser;
    private List<Integer> idsRoles;
}