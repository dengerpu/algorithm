package com.ep.LeetCode_Type.DoublePointer;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-16 8:59
 */
public class exercise2_344_反转字符串 {
    public static void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0,j = n - 1; i < j ; i++, j--) {
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
