package com.ep.AcWing.dynamic;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-25 11:08
 */
public class AcWing2_01背包问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] V = new int[n+1]; // 存放物品的体积
        int[] W = new int[n+1]; // 存放物品的价值
        int[][] f = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            V[i] = scanner.nextInt();
            W[i] = scanner.nextInt();
        }

        /*
        f[i][j] 表示只看前i个物品，总体积是j的情况下，总价值最大是多少
        result = max(f[n][0-v])

        f[i][j]:
        1. 不选第i个物品，f[i][j] = f[i-1][j],从前i-1个物品选出不超过j的总体积
        2. 选第i个物品， f[i][j] = f[i-1][j-v[i]]; 选择了i,且i的体积为

        f[i][j] = max{1,2};
        f[0][0] = 0;
         */

        // 使用二维数组
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= m; j++) {
//                f[i][j] = f[i-1][j];
//                if (j >= V[i])
//                    f[i][j] = Math.max(f[i][j],f[i-1][j- V[i]] + W[i]);
//            }
//        }
//        int res = 0;
//        for (int i = 0; i <= m ; i++) res = Math.max(res, f[n][i]);

        int[] dp = new int[m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= V[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-V[i]] + W[i]);
            }
        }

        System.out.println(dp[m]);
    }
}
