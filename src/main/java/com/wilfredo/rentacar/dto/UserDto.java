package com.wilfredo.rentacar.dto;

import com.wilfredo.rentacar.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {

     private Long id;

    private String username;

    private String email;

    private UserRole userRole;

}
