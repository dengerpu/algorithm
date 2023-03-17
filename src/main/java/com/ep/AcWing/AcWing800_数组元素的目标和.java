package com.ep.AcWing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-17 10:15
 */
public class AcWing800_数组元素的目标和 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2]);
        int[] a = new int[n];
        int[] b = new int[m];
        String[] s1 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
        }
        String[] s2 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(s2[i]);
        }
        int j = m - 1;
        for (int i = 0; i < n; i++) {
            while (j >= 0 && a[i] + b[j] > x) j--;
            if (a[i] + b[j] == x) {
                System.out.println(i + " " + j);
                break;
            }
        }
    }
}
