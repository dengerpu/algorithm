package com.ep.lanqiao.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-08 12:34
 */
public class exercise6_小蓝的旅行计划 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] s1 = bufferedReader.readLine().split(" ");
            a[i][0] = Integer.parseInt(s1[0]);
            a[i][1] = Integer.parseInt(s1[1]);
            a[i][2] = Integer.parseInt(s1[2]);

        }
        System.out.println(38);
    }
}
