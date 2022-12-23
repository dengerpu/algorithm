package com.ep.LeetCode;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-23 11:28
 */
public class exercise344_翻转字符串 {
    public static void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n/2; i++) {
            char t = s[i];
            s[i] = s[n-i-1];
            s[n-i-1] = t;
        }
    }

    public static void main(String[] args) {
        char[] s = {'H','a','n','n','a','h'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
