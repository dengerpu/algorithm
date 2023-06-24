package com.ep.LeetCode_Type.DynamicProgramming;

import org.junit.experimental.max.MaxCore;

/***
 * @author dep
 * @version 1.0
 * @date 2023-06-24 9:14
 */
public class exercise27_714_买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        // dp[i][0]代表买入状态，或者保持现状状态
        // dp[i][1]代表卖出状态或者保持现状
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
