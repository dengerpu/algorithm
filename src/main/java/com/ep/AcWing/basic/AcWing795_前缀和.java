package com.ep.AcWing.basic;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-10 22:31
 */
public class AcWing795_前缀和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int [] sums = PrefixSum(arr,n);
        while (m!= 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(sums[r] - sums[l-1]);
            m--;
        }
    }
    // 求前缀和
    public static int[] PrefixSum(int[] arr, int n) {
        int[] sum = new int[n+1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + arr[i-1];
        }
        return sum;
    }
}
