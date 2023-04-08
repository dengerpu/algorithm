package com.ep.lanqiao.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-08 9:51
 */
public class exercise4_子矩阵 {
    static int N = 1010;
    static int M = 998244353;
    static int[][] arr = new int[N][N];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int a = Integer.parseInt(s[2]);
        int b = Integer.parseInt(s[3]);
        for (int i = 1; i <= n; i++) {
            String[] s1 = bufferedReader.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(s1[j-1]);
            }
        }
        System.out.println(getMaxValue(n, m, a, b));
    }
    public static long getMaxValue(int n, int m, int a, int b) {
        long sum = 0;
        for (int i = 1; i <= n - a + 1; i++) {
            for (int j = 1; j <= m - b + 1; j++){
                sum = (sum +  getValue(i,j,i +a - 1, j + b - 1)) % M;
            }
        }
        return sum;
    }
    public static long  getValue(int x1, int y1, int x2, int y2) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }
        return (max * min) % M;
    }
}
