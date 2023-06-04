package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-06-04 10:25
 */
public class exercise20_213_打家劫舍II {
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(findMax(nums, 0, nums.length - 2), findMax(nums, 1 , nums.length - 1));
    }
    public static int findMax(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int[] dp = new int[end + 1];
        dp[start] = nums[start];

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i -2] + nums[i], dp[i - 1]);
        }

        return dp[end];
    }

    public static void main(String[] args) {
        int[] nums = {0,0};
        System.out.println(rob(nums));
    }
}
