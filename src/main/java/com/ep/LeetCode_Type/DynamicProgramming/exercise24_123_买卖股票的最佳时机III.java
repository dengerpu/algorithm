package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-06-10 10:16
 */
public class exercise24_123_买卖股票的最佳时机III {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][5];
        // 一共5个状态
        // 0 什么也不操作
        // 1 第一次持有股票
        // 2 第一次不持有股票
        // 3 第二次持有股票
        // 4 第二次不持有股票
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < n; i++) {
           dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
           dp[i][2] = Math.max(dp[i-1][1] + prices[i], dp[i-1][2]);
           dp[i][3] = Math.max(dp[i-1][2] - prices[i], dp[i-1][3]);
           dp[i][4] = Math.max(dp[i-1][3] + prices[i], dp[i-1][4]);
        }
        return dp[n-1][4];
    }

    public static void main(String[] args) {
       int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
}
