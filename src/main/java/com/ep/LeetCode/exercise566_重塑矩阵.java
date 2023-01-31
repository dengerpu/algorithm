package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-31 10:26
 */
public class exercise566_重塑矩阵 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m*n != r*c) {
            return mat;
        }
        int[][]  ans = new int[r][c];
        for (int i = 0; i < m*n; i++) {
            ans[i / c][i % c] = mat[i / n][i % n];
        }
        return ans;
    }
}
