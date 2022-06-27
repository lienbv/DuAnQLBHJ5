package com.asm.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "bill_detail")
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_drinkingCup")
    private Long idDrinkingcup;

    @Column(name = "id_bill")
    private Long idBill;
    @Column(name = "amount", nullable = true)
    private Long amount;


}