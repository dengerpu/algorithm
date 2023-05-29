package com.ep.LeetCode_Type.DynamicProgramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-29 9:28
 */
public class exercise14_377_组合总和4 {
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) { // 背包
            for (int j = 0; j < nums.length; j++) { // 物品
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    static int Count = 0;
    public static int combinationSum42(int[] nums, int target) {
        backTracking(nums, target, 0);
        return Count;
    }

    public static void backTracking(int[] nums, int target, int sum) {
        if (sum == target) {
            Count++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= target) {
                backTracking(nums, target, sum + nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        int target = 35;
        System.out.println(combinationSum4(nums, target));
        System.out.println(combinationSum42(nums, target));
    }
}
