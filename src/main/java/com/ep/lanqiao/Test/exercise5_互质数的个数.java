package com.ep.lanqiao.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-08 10:17
 */
public class exercise5_互质数的个数 {
    static int M = 998244353;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        long a = Long.parseLong(s[0]);
        long b = Long.parseLong(s[1]);
        System.out.println((FUN(a) * POW(a, b-1)) % M);
    }
    public static long FUN(long m) {
        long ans = m;
        for (long i = 2; i <= Math.sqrt(m); i++) {
            if (m % i == 0) {
                ans = ans / i * (i - 1);
                while (m % i == 0) {
                    m /= i;
                }
            }
        }
        if (m > 1) {
            ans = ans / m * (m - 1);
        }
        return ans;
    }

    public static long POW(long a, long b) {
        long ans = 1;
        a %= M;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % M;
            }
            a = a * a % M;
            b >>= 1;
        }
        return ans;
    }
}
