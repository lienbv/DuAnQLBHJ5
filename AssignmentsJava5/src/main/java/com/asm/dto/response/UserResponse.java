package com.asm.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class UserResponse{
    private  String fullname;
    private  String address;
    private  String email;
    private  String img;
    private  String phoneNumber;
    private  String status;
    private  Date createDate;
    private int role;
    private String username;
    private String password;
}
