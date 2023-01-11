package com.ep.LeetCode;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-11 18:12
 */
public class exercise504_七进制数 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negative = num < 0;
        num = Math.abs(num);
        StringBuffer digits = new StringBuffer();
        while (num > 0) {
            digits.append(num % 7);
            num/=7;
        }
        if (negative) {
            digits.append('-');
        }
        return digits.reverse().toString();
    }
}
