package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-15 9:31
 */
public class exercise7_96_不同的二叉搜索树 {
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            // dp[i] 为 1...i为头结点的二叉搜索树的个数的和
            for (int j = 1; j <= i; j++) {
                //代表以j为头结点 dp[j-1] * dp[i-j];
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
