package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-23 11:28
 */
public class exercise717_1比特与2比特字符 {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;
        while (i < n - 1) {
            i += bits[i] + 1;
        }
        return i == n - 1;
    }

    public boolean isOneBitCharacter2(int[] bits) {
        int n = bits.length, i = n - 2;
       while (i >= 0 && bits[i] == 1) {
           i--;
       }
       return (n - i) % 2 == 0;
    }
}
