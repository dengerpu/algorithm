package com.ep.LeetCode;

import java.util.ArrayList;
import java.util.Map;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-26 11:16
 */
public class exercise746_使用最小花费爬楼梯 {
    // 动态规划
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i-1], prev + cost[i-2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }

    // 动态规划
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[n];
    }
}
