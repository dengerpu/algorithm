package com.ep.AcWing;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-08 20:14
 */
public class AcWing794_高精度除法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] a_array = scanner.next().toCharArray();
        int b = scanner.nextInt();
        div(a_array, b);
    }
    public static void div(char[] a, int b) {
        StringBuffer result = new StringBuffer();
        int t = 0;
        for (int i = 0; i < a.length; i++) {
            t = t* 10 + (a[i] - '0');
            result.append(t / b);
            t = t % b;
        }
        // 需要去掉前缀0
        StringBuffer res = result.reverse();
        while (res.length() > 1 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }
        System.out.println(res.reverse().toString());
        System.out.println(t);
    }
}
