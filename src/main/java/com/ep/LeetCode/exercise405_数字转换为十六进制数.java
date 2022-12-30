package com.ep.LeetCode;

import java.math.BigInteger;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-30 11:48
 */
public class exercise405_数字转换为十六进制数 {
    // 位运算
    public static String toHex(int num) {
        if(num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 7; i >= 0; i--) {
            // 0xf=0000 0000 0000 0000 0000 0000 0000 1111
            int val = (num >> (4*i)) & 0xf; // 可以得到二进制的前四位，也就是十六进制的第一位
            if (sb.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 26;
        System.out.println(toHex(num));
    }
}
