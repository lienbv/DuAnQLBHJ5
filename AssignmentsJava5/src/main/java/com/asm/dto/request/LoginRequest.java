package com.asm.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginRequest{
    @NotBlank
    @Size(max = 20, min = 6)
    private String username;
    @NotBlank
    @Size(max = 20, min = 6)
    private String password;
}
