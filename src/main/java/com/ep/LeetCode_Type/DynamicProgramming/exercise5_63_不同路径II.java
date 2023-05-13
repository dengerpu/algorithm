package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-13 9:42
 */
public class exercise5_63_不同路径II {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 1. dp[i][j] 表示从起点到终点路径数量
        // 2. 递推公式  dp[i][j] = dp[i-1][j] + di[i][j-1];
        // dp[i-1][j]向下走一步到达dp[i][j], dp[i][j-1] 向右走一步到达dp[i][j]
        // 3. dp数组初始化 dp[i][0] = 1; dp[0][j] = 1;
        // 4. 顺序遍历
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{1,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
