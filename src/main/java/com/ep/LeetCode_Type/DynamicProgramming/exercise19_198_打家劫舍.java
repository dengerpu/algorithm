package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-06-03 10:12
 */
public class exercise19_198_打家劫舍 {
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

       // 01 背包问题
        for (int i = 2; i < n ; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            System.out.println(dp[i]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
}
