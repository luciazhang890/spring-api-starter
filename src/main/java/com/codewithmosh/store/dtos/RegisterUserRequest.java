package com.codewithmosh.store.dtos;

import lombok.Data;


@Data  // combination of getter and setter
//@Getter
//@Setter
public class RegisterUserRequest {
    private String name;
    private String email;
    private String password;
}
