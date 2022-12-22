package com.ep.LeetCode;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-22 11:55
 */
public class exercise338_比特位计数 {
    public static int[] countBits(int n) {
        int[] arr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = countNumber(i);
        }
        return arr;
    }
    public static int countNumber(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    // 答案解法二：动态规划-最高有效位
    public int[] countBits2(int n) {
        int[] bits = new int[n+1];
        int highBit = 0;
        for (int i = 1; i <=n ; i++) {
            if ((i & (i-1)) == 0) {  // 是不是2的倍数，2的倍数就会多个1
                highBit = i;
            }
            bits[i] = bits[i-highBit] + 1;
        }
        return bits;
    }
    // 1   001   1&0 = 0   highBit=1
    // 2   010   2&1 = 0   highBit=2
    // 3   011   3&2 = 2

    // 答案解法三：动态规划-最低有效位
    public int[] countBits3(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i&1);
        }
        return bits;
    }

    // 答案解法四：动态规划-最低设置位
    public int[] countBits4(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i& (i-1)] + 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ints = countBits(n);
        System.out.println(Arrays.toString(ints));
    }
}
