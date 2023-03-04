package com.ep.LeetCode_Type.Array;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-04 9:02
 */
public class exercuse14_59_螺旋矩阵II {
    // 遵循左闭右开的规则
    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int count = 1;
        int start = 0;
        int loop = 0; // 循环的次数
        int i, j;
        while (loop < n / 2) { // 循环的次数，每次循环顺时针
            loop++;
            // 上侧：从左往右循环
            for (i = start; i < n - loop; i++) {
                arr[start][i] = count++;
            }
            // 右侧：从上向下(此时i = n - 1)
            for (j = start; j < n - loop; j++) {
                arr[j][i] = count++;
            }
            // 下侧：从右到左（此时j = n - 1）
            for (;i>=loop;i--) {
                arr[j][i] = count++;
            }
            // 左侧：从下到上 (此时 i = start, = n - 1)
            for (;j>=loop;j--) {
                arr[j][i] = count++;
            }
            start++;
        }
        if (n % 2 != 0) {
            arr[start][start] = count;
        }
        return arr;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] result = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
