package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-22 12:39
 */
public class exercise342_4的幂 {
    public static boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 1) {
            if (n % 4 != 0) {
                return false;
            }
            n = n / 4;
        }
        return true;
    }

    // 答案方法一：二进制表示中1的位置
    public boolean isPowerOfFour2(int n) {
        // n & (n-1)) == 0 表示2的幂次方
        // 10101010101010101010101010101010


        return n > 0 && (n & (n-1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }


    // 答案方法二： 取模性质
    public boolean isPowerOfFour3(int n) {
        return n > 0 && (n & (n-1)) == 0 && (n % 3 == 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(isPowerOfFour(n));
    }
}
