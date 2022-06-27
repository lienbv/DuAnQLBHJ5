package com.asm.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
@Data
@Entity
@Table(name = "drinkingcups")
public class Drinkingcup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "img", nullable = true)
    private String img;

    @Column(name = "id_category", nullable = true)
    private Long idCategory;

    @Column(name = "description", nullable = true, length = 225)
    private String description;

    @Column(name = "price", nullable = true)
    private Double price;

    @Column(name = "promotion", nullable = true)
    private Integer promotion;

    @Column(name = "color", nullable = true)
    private String color;

    @Column(name = "size", nullable = true, length = 100)
    private String size;

    @Column(name = "volume", nullable = true)
    private Double volume;

    @Column(name = "material", nullable = true)
    private String material;

    @Column(name = "status", nullable = true)
    private int status;

    @Column(name = "create_date", nullable = true)
    private Date createDate;

    @Column(name = "amount", nullable = true)
    private Long amount;

}