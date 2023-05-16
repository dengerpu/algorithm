package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-16 9:46
 */
public class exercise8_01背包问题 {

    /**
     * @param weight 物品的重量
     * @param value 物品的价值
     * @param bagSize 物品大小
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int m = weight.length;
        int n = bagSize + 1;
        int[][] dp = new int[m][n]; // dp[i][j], 0-i个物品，j背包的重量
        // 数组初始化
//        for (int i = 0; i < m; i++) { // 背包的容量为0
//            dp[i][0] = 0;
//        }
//        for (int j = 1; j < n; j++) { // 放索引为0的物品
//            if (weight[0] <= j) {
//                dp[0][j] = value[0];
//            } else {
//                dp[0][j] = 0;
//            }
//        }
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }
        // 两种情况： 1. 不选择第i个物品 dp[i-1][j]  2. 选择第i个物品  dp[i-1][j - weight[i]] + value[i]
        for (int i = 1; i < m; i++) { // 物品
            for (int j = 1; j < n; j++) { // 背包重量
                if (j < weight[i]) {
                    // 此时物品重量已经超越了背包的最大承受重量
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }
        // 打印dp数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
//        int[] weight = {1,3,4};
//        int[] value = {15,20,30};
//        int bagSize = 4;
        int[] weight = {1,2,3,4};
        int[] value = {2,4,4,5};
        int bagSize = 5;
        testWeightBagProblem(weight,value,bagSize);
    }
}
