package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-06-11 10:41
 */
public class exercise25_188_买卖股票的最佳时机IV {
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][2 * k + 1];

        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }

        // 奇数买入
        // 偶数卖出
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                // 奇数买入
                dp[i][j+1] = Math.max(dp[i-1][j] - prices[i],dp[i-1][j + 1]);
                // 偶数卖出
                dp[i][j+2] = Math.max(dp[i-1][j+1] + prices[i],dp[i-1][j + 2]);
            }
        }
        return dp[n-1][2 * k];
    }

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3,2,6,5,0,3};
        System.out.println(maxProfit(k, prices));
    }
}
