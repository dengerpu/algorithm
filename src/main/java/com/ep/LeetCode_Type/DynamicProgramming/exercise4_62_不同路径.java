package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-11 11:10
 */
public class exercise4_62_不同路径 {
    // 转化为求二叉树叶子结点的个数 (会超时)
    public static int uniquePaths(int m, int n) {
        return dfs(1,1,m,n);
    }

    public static int dfs(int i, int j, int m, int n) {
        if (i > m || j > n) return 0;
        if (i == m && j == n) return 1; // 找到了一种方法，相当于找到了叶子结点
        return dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
    }


    public static int uniquePaths2(int m, int n) {
        // 1. 确定dp数组的含义  dp[i][j]表示从0,0起点出发到终点的路径
        // 2. 递推公式  dp[i][j] = dp[i-1][j] + dp[i][j-1];
        // 从dp[i-1][j]向右走一步，dp[i][j-1]向下走一步都可以到达dp[i][j]
        // 3. 数组初始化dp[i][0] = 1, dp[0][j] = 1
        // 4. 遍历顺序
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths2(2, 3));
    }
}
