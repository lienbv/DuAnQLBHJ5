package com.asm.dto.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class DrinkingcupCreateRequest {

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


}
