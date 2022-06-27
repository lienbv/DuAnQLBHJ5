package com.asm.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "user_id")
    private Long user;

    @Column(name = "role_id")
    private Long role;


}