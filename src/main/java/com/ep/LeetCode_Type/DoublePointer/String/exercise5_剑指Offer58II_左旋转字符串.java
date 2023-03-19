package com.ep.LeetCode_Type.DoublePointer.String;

import javax.print.DocFlavor;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-14 9:49
 */
public class exercise5_剑指Offer58II_左旋转字符串 {
    // 思路：旋转全部字符串
    // 然后分别旋转
    public static String reverseLeftWords(String s, int n) {
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        reverseString(sb,0,sb.length() - n - 1);
        reverseString(sb,sb.length() - n, sb.length() - 1);
        return sb.toString();
    }
    public static void reverseString(StringBuffer sb, int left, int right) {
        while (left < right) {
            char c = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, c);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String s = "lrloseumgh";int k = 6;
        System.out.println(reverseLeftWords(s, k));
    }
}
