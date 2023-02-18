package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-18 19:37
 */
public class exercise709_转换成小写字母 {
    public static String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
//                chars[i] += 32;
                chars[i] |= 32;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(toLowerCase(s));
    }
}
