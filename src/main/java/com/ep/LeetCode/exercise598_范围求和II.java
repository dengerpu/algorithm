package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-04 11:35
 */
public class exercise598_范围求和II {
    // 会超出内存限制
    public static int maxCount(int m, int n, int[][] ops) {
        int[][] M = new int[m][n];
        int max = 0;
        for (int i = 0; i < ops.length; i++) {
            int a = ops[i][0], b = ops[i][1];
            for (int j = 0; j < M.length; j++) {
                for (int k = 0; k < M[j].length; k++) {
                    if (j < a && k < b) {
                        M[j][k] += 1;
                        if (M[j][k] > max) {
                            max = M[j][k];
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int j = 0; j < M.length; j++) {
            for (int k = 0; k < M[j].length; k++) {
                if (M[j][k] == max) {
                    count++;
                }
            }
        }
        return count;
    }
    // 答案解法：
    public int maxCount2(int m, int n, int[][] ops) {
        int mina = m, minb = n;
        for (int[] op : ops) {
            mina = Math.min(mina, op[0]);
            minb = Math.min(minb,op[1]);
        }
        return mina * minb;
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        int [][] ops = {{2,2},{3,3}};
        System.out.println(maxCount(m, n, ops));
    }
}
