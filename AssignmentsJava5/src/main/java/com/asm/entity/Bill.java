package com.asm.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Data
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "id_user", nullable = true)
    private Long idUser;

    @Column(name = "total", nullable = true)
    private Double total;

    @Column(name = "status", nullable = true)
    private String status;



}