package com.ep.AcWing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-13 13:01
 */
public class AcWing797_差分 {
    static int N = 100010;
    static int[] b = new int[N];
    static int[] a = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String[] s1 = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s1[i-1]);
            insert(i,i,a[i]);
        }
        while (m > 0) {
            String[] s2 = br.readLine().split(" ");
            int l = Integer.parseInt(s2[0]);
            int r = Integer.parseInt(s2[1]);
            int c = Integer.parseInt(s2[2]);
            insert(l,r,c);
            m--;
        }
        for (int i = 1; i <= n; i++) {
            a[i] = a[i-1] + b[i];
            System.out.print(a[i] + " ");
        }
    }
    public static void insert(int l, int r, int c){
        b[l] += c;
        b[r + 1] -= c;
    }
}
