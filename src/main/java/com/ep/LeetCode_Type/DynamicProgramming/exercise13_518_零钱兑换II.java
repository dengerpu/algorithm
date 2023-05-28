package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-27 9:57
 */
public class exercise13_518_零钱兑换II {
    public static int change(int amount, int[] coins) {
        int bagSize = amount;
        int[] dp = new int[bagSize + 1];

        dp[0] = 1;

        // 完全背包问题中，先物品再背包是组合， 先背包再物品是排列

        for (int i = 0; i < coins.length; i++) { // 物品
            for (int j = coins[i]; j <= bagSize; j++) { // 背包
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[bagSize];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
    }
}
