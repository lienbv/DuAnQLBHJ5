package com.asm.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CheckoutRequest {
    @NotBlank
    @Size(min = 2, max = 100)
    private String fullname;
    @NotBlank
    private String address;
    @NotBlank
    @Email
    private String email;
    private String img;
    @NotBlank
    private String phoneNumber;

}
