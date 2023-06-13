package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-06-13 9:32
 */
public class exercise26_309_最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        // dp[i][0] 状态1：持有股票
        // dp[i][1] 状态2：不持有股票 保持卖出的状态
        // dp[i][2] 状态3：不持有股票 今天卖出
        // dp[i][3] 状态4： 今天冷冻期
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 继续保持前一天状态， 今天买入 前一天冷冻期可以买入股票，前一天是保持卖出状态
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][3] - prices[i],dp[i-1][1] - prices[i]));
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
            dp[i][2] = dp[i-1][0] + prices[i];
            dp[i][3] = dp[i-1][2];
        }
        return Math.max(dp[n-1][3], Math.max(dp[n-1][1], dp[n-1][2]));
    }
}
