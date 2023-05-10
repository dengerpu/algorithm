package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-10 9:16
 */
public class exercise3_746_使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        // 1. dp数组的含义 dp[i],到达第i个位置的最小花费
        // 2. 递推公式  dp[i] = min (dp[i-1] + cost[i-1], dp[i-1] + cost[i-2])
        // 3. 数组初始化 dp[0] = 0  dp[1] = 0
        // 4. 遍历顺序
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[n];
    }
    // 简化空间复杂度
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int prev = 0;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i-1] , prev + cost[i-2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
