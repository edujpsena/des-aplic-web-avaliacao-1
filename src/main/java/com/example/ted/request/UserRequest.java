package com.example.ted.request;

import lombok.Data;

@Data
public class UserRequest {

    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private String password;
}
