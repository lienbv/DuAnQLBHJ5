package com.asm.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
public class UserRequest {
    @NotBlank
    @Size(min = 2, max = 100)
    private String fullname;
    @NotBlank
    @Size(min = 6, max = 20)
    private String address;
    @NotBlank
    @Email()
    private String email;
    private String img;
    @NotBlank
    private String phoneNumber;
    private int role;
    @NotBlank
    @Size(min = 6, max = 20)
    private String username;
    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
    @NotBlank
    @Size(min = 6, max = 20)
    private String rePassword;
}
