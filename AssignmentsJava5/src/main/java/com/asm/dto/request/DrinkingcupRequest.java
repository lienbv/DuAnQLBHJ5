package com.asm.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class DrinkingcupRequest {

    private Long id;

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

    private Long amount;

    private int status;

}
