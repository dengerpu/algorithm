package com.ep.AcWing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-16 10:51
 */
public class AcWing_798_差分矩阵 {
    static int N = 1010;
    static int[][] A = new int[N][N];
    static int[][] B = new int[N][N];
    public static void insert(int x1, int y1, int x2, int y2, int c) {
        B[x1][y1] += c;
        B[x1][y2+1] -= c;
        B[x2+1][y1] -= c;
        B[x2+1][y2+1] += c;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int q = Integer.parseInt(s[2]);
        for (int i = 1; i <= n; i++) {
            String[] s1 = bufferedReader.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                A[i][j] = Integer.parseInt(s1[j-1]);
                insert(i,j,i,j,A[i][j]);
            }
        }
        while (q != 0) {
            String[] s1 = bufferedReader.readLine().split(" ");
            int x1 = Integer.parseInt(s1[0]);
            int y1 = Integer.parseInt(s1[1]);
            int x2 = Integer.parseInt(s1[2]);
            int y2 = Integer.parseInt(s1[3]);
            int c = Integer.parseInt(s1[4]);
            insert(x1,y1,x2,y2,c);
            q--;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                A[i][j] = A[i-1][j] + A[i][j-1] - A[i-1][j-1] + B[i][j];
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
