package com.aluraforo.desafio_foro.domain.usuario;


import lombok.Data;

@Data
public class RegisterRequest {

    private String username;
    private String email;
    private String password;
}
