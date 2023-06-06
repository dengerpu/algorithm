package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-06-06 9:17
 */
public class exercise22_121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        // dp[i][0]代表第i天持有股票的最大收益
        // dp[i][1]代表第i天不持有股票的最大收益
        for (int i = 1; i < prices.length; i++) {
            // 第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
            // 第i天买入股票，所得现金就是买入今天的股票后所得现金即：-prices[i]
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            // 第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不持有股票的所得现金 即：dp[i - 1][1]
            // 第i天卖出股票，所得现金就是按照今天股票价格卖出后所得现金即：prices[i] + dp[i - 1][0]
            dp[i][1] = Math.max(dp[i-1][0] + prices[i], dp[i-1][1]);
        }
        return dp[n - 1][1];
    }
}
