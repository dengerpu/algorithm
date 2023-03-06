package com.ep.AcWing;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-06 15:10
 */
public class AcWing791_高精度加法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] a_array = new StringBuffer(scanner.next()).reverse().toString().toCharArray();
        char[] b_array = new StringBuffer(scanner.next()).reverse().toString().toCharArray();
        System.out.println(add(a_array, b_array));

    }
    public static String add(char[] a, char[] b) {
        int m = a.length, n = b.length;
        if (m < n) return add(b,a);
        StringBuffer result = new StringBuffer();
        int t = 0;
        for (int i = 0; i < m; i++) {
            t+=a[i] - '0';
            if (i < n){
                t+=b[i] - '0';
            }
            result.append(t % 10);
            t /= 10;
        }
        if (t == 1) result.append('1');
        return result.reverse().toString();
    }
}
