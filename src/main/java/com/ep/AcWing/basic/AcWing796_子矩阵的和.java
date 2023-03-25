package com.ep.AcWing.basic;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-11 9:31
 */
public class AcWing796_子矩阵的和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        int[][] arr = new int[n+1][m+1];
        int[][] sums = new int[n+1][m+1];
        // 求前缀和
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = scanner.nextInt();
                sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + arr[i][j];
            }
        }
        while (q > 0) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            System.out.println(sums[x2][y2] - sums[x1-1][y2] - sums[x2][y1-1] + sums[x1-1][y1-1]);
            q--;
        }
    }
}
