package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-08 9:24
 */
public class exercise1_509_斐波那契数 {
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // 1. 确定dp数组，以及下标的含义
        // 2.确定递推公式 dp[i] = dp[i-1] + dp[i-2]
        int[] dp = new int[n+1];
        // 3.初始化数组
        dp[0] = 0; dp[1] = 1;
        // 4.确定顺序
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(fib(i));
        }

    }
}
