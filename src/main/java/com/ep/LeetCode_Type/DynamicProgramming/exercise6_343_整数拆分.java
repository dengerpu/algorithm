package com.ep.LeetCode_Type.DynamicProgramming;

import org.junit.experimental.max.MaxCore;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-14 12:58
 */
public class exercise6_343_整数拆分 {

    // 贪心
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        result *= n;
        return result;
    }

    public int integerBreak2(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i-j] * j));
            }
        }
        return dp[n];
    }

}
