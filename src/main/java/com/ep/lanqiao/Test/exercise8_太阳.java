package com.ep.lanqiao.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-08 12:18
 */
public class exercise8_太阳 {
    static int N = 1010;
    static int[][] arr = new int[N][3];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int y = Integer.parseInt(s[2]);
        for (int i = 0; i < n; i++) {
            String[] s1 = bufferedReader.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s1[0]);
            arr[i][1] = Integer.parseInt(s1[1]);
            arr[i][2] = Integer.parseInt(s1[2]);
        }
        int count = n;
        for (int i = 1; i < n; i++) {
            if (arr[i -1][1] >= arr[i][1] && arr[i][2] < arr[i-1][2] && arr[i-1][1] + arr[i-1][2] >= arr[i][2] + arr[i][1]) {
                count--;
            }
        }
        System.out.println(count);
    }
}
