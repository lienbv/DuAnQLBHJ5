package com.asm.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Stastus {
    String message="";
    String stastus="";
    public static String Success="1";
    public static String Fail="0";
}
