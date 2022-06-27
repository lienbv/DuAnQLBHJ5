package com.asm.dto.response;

import lombok.Data;

@Data
public class DrinkingCupResponse{
    private  String name;
    private  String img;
    private  Long idCategory;
    private  String description;
    private  Double price;
    private  int promotion;
    private  String color;
    private  String size;
    private  Double volume;
    private  String material;
    private  int status;
    private Long amount;
}
