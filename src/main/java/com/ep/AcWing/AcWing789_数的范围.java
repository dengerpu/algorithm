package com.ep.AcWing;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-04 14:51
 */
public class AcWing789_数的范围 {
    static int[] arr = new int[100010];
    public static void main(String[] args) {
        int n, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        while (m-- != 0) {
            int x = scanner.nextInt();
            int l = -1, r = n;
            while (l + 1 != r) { // 寻做左边界
                int mid = l + r >> 1;
                if (arr[mid] >= x) r = mid;
                else l = mid;
            }
            if (arr[r] != x) {
                System.out.println("-1 -1");
            }
            else { // 寻找右边界
                System.out.print(r + " ");
                l = -1; r = n;
                while (l + 1 != r) {
                    int mid = l + r >> 1;
                    if (arr[mid] <= x) l = mid;
                    else r = mid;
                }
                if (arr[l] != x) System.out.println(r);
                else System.out.println(l);
            }
        }
    }
}
