package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-09 9:15
 */
public class exercise2_70_爬楼梯 {
    public int climbStairs(int n) {
        if(n == 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 最后一步一个台阶或者两个台阶
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
