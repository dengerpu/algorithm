package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-30 9:09
 */
public class exercise15_70_爬楼梯 {
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n ; i++) { // 背包
            for (int j = 1; j <= 2; j++) { // 物品
                if (i >= j) {
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }
}
