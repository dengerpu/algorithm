package com.ep.LeetCode_Type.String;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-13 8:53
 */
public class exercise1_344_反转字符串 {
    public static void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            char c = s[i];
            s[i] = s[n-1-i];
            s[n-1-i] = c;
        }
    }
    public static void reverseString2(char[] s) {
        int n = s.length;
        for (int left = 0,right = n - 1; left < right; left++, right--) {
           char c = s[left];
           s[left] = s[right];
           s[right] = c;
       }
    }

    public static void reverseString3(char[] s) {
        int n = s.length;
        for (int left = 0,right = n - 1; left < right; left++, right--) {
            s[left] ^= s[right];  // a = a ^ b
            s[right] ^= s[left]; // b = b ^ (a^b) = a, a = a ^ b;
            s[left] ^= s[right]; // a = (a ^ b) ^ a   = b
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);

    }
}
