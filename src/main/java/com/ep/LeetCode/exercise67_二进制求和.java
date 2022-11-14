package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 */
public class exercise67_二进制求和 {
    // 方法一： 转化为十进制求和，然后再转化为二进制（不可行，计算范围有限）
    public static String addBinary1(String a, String b) {
        return Integer.toBinaryString(
        Integer.parseInt(a,2) + Integer.parseInt(b,2)
        );
    }
    public static String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int aLength = a.length();
        int bLength = b.length();
        int n = Math.max(aLength, bLength), carry = 0;
        for (int i = 0; i< n; i++) {
           if (i < aLength) {
               carry += a.charAt(a.length() - i - 1) - '0';
           }
           if (i < bLength) {
               carry += b.charAt(b.length()- i - 1) - '0';
           }
           ans.append((char)(carry % 2 + '0'));
           carry /= 2;
        }
        if (carry > 0) ans.append('1');
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a,b));
    }
}
