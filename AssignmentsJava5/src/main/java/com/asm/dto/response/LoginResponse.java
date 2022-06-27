package com.asm.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class LoginResponse{
    private String username;
    private List<String> roles;
    private String fullname;
    private String phoneNumbeer;
    private String address;
    private String email;
}
