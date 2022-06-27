package com.asm.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;


@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_drinkingCups", nullable = false)
    private Drinkingcup idDrinkingCups;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    public Long getId() {
        return id;
    }

    public Drinkingcup getIdDrinkingCups() {
        return idDrinkingCups;
    }

    public Long getAmount() {
        return amount;
    }

    public Double getPrice() {
        return price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public double total() {
        return this.amount * (this.getIdDrinkingCups().getPrice());

    }
    public double totalAll() {
        double sum=0;
        return sum+=this.total();
    }
    public double totalPromotion() {
        double promotion = total() * (100 - this.getIdDrinkingCups().getPromotion());
        return promotion;
    }


    public Long amountAdd() {
        return amount++;
    }
    public Long amountUp() {
        return amount--;
    }

    public Cart(Long amount, Drinkingcup idDrinkingCups) {
        super();
        this.amount = amount;
        this.idDrinkingCups = idDrinkingCups;
    }
}