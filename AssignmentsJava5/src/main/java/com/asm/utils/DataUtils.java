package com.asm.utils;

import java.util.Random;

public class DataUtils {
    public static String generateTempPwd(int num) {

        String numbers ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@#$%!^*?&~";
        char otp[] = new char[num];
        Random getOtpNum = new Random();
        for (int i = 0; i < num; i++) {
            otp[i] = numbers.charAt(getOtpNum.nextInt(numbers.length()));
        }
        String optCode = "";
        for (int i = 0; i < otp.length; i++) {
            optCode += otp[i];
        }
        return optCode;
    }
}
