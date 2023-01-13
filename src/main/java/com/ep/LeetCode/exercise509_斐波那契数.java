package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-12 17:41
 */
public class exercise509_斐波那契数 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }else if (n == 1) {
            return 1;
        }else {
            return fib(n-1) + fib(n-2);
        }
    }
    // 答案解法一：动态规划
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
    // 答案解法二：矩阵快速幂
    public int fib3(int n) {
        if (n < 2) {
            return n;
        }
        int [][] q = {{1,1}, {1,0}};
        int [][] res = pow(q, n - 1);
        return res[0][0];
    }
    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1,0},{0,1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }
    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}
