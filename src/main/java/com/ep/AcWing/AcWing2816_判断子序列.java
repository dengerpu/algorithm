package com.ep.AcWing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-17 10:28
 */
public class AcWing2816_判断子序列 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
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
        int i = 0, j = 0;
        while(i < n && j < m) {
            if (a[i] == b[j]) i++;
            j++;
        }
        if (i == n) System.out.println("Yes");
        else System.out.println("No");
    }
}
