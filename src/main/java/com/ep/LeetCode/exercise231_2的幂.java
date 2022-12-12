package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-12 11:14
 */
public class exercise231_2的幂 {
    public static boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        while (n != 1){
            if (n % 2 != 0) {
                return false;
            }
            n = n/2;
        }
        return true;
    }

    // 方法一 二进制表示
    // 一个数 nnn 是 222 的幂，当且仅当 nnn 是正整数，并且 nnn 的二进制表示中仅包含 1 个 1。
    public static boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

    // 方法二：判断是否为最大 222 的幂的约数
    // 在题目给定的 323232 位有符号整数的范围内，最大的 222 的幂为 230=10737418242^{30} = 10737418242
    static final int BIG = 1 << 30;

    public boolean isPowerOfTwo3(int n) {
        return n > 0 && BIG % n == 0;
    }


    public static void main(String[] args) {
        int n = 0;
        System.out.println(isPowerOfTwo(n));
    }
}
