package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-06-07 9:44
 */
public class exercise23_122_买卖股票的最佳时机II {
    public static int maxProfit(int[] prices) {
      int n = prices.length;
      int[][] dp = new int[n][2];
      dp[0][0] = -prices[0];
      dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 第i天持有股票即dp[i][0]
            // 第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
            // 第i天买入股票，所得现金就是昨天不持有股票的所得现金减去 今天的股票价格 即：dp[i - 1][1] - prices[i]
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);

            // dp[i][1] 表示第i天不持有股票所得最多现金
            // 第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不持有股票的所得现金 即：dp[i - 1][1]
            // 第i天卖出股票，所得现金就是按照今天股票价格卖出后所得现金即：prices[i] + dp[i - 1][0]
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return dp[n-1][1];
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
