package com.mylib.cadastro.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateUserRoleDTO {

    private Integer idUser;
    private List<Integer> idsRoles;
}