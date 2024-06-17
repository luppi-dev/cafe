package br.com.luppi.api.cafe.dto;

import lombok.Data;

@Data
public class NewUserRequest {
    private String name;
    private String email;
    private String password;
}
