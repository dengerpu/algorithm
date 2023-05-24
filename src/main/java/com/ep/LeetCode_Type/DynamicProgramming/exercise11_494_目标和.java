package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-24 9:29
 */
public class exercise11_494_目标和 {
    public int findTargetSumWays(int[] nums, int target) {
        // 加法集合用left来表示，减法结合用right来表示， 则1. left + right = sum
        // 2. left - right = target   1和2结合left = (sum + target) / 2
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (Math.abs(target) > sum) return 0;
        if ((sum + target) % 2 == 1) return 0;
        int bagSize = (sum + target) / 2;

        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
//        已经有一个1（nums[i]） 的话，有 dp[4]种方法 凑成 容量为5的背包。
//        已经有一个2（nums[i]） 的话，有 dp[3]种方法 凑成 容量为5的背包。
//        已经有一个3（nums[i]） 的话，有 dp[2]中方法 凑成 容量为5的背包
//        已经有一个4（nums[i]） 的话，有 dp[1]中方法 凑成 容量为5的背包
//        已经有一个5 （nums[i]）的话，有 dp[0]中方法 凑成 容量为5的背包
        for (int i = 0; i < nums.length; i++) { // 物品
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
