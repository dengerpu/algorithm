package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-06-01 10:27
 */
public class exercise17_279_完全平方数 {
    public static int numSquares(int n) {
        int q = (int) Math.sqrt(n);
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= q; i++) { // 遍历物品
            for (int j = i * i; j <= n ; j++) {
                if (j >= i * i) {
                    dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(numSquares(n));
    }
}
