package com.ep.AcWing;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-08 19:30
 */
public class AcWing793_高精度乘法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] a_arrray = new StringBuffer(scanner.next()).reverse().toString().toCharArray();
        int b = scanner.nextInt();
        System.out.println(mul(a_arrray, b));
    }
    public static String mul(char[] a, int b) {
        int t = 0;
        StringBuffer result = new StringBuffer();
        // t!= 0,最后余数可能不是个位数
        for (int i = 0; i < a.length || t != 0; i++) {
            if (i < a.length) t += (a[i] - '0')  * b;
            result.append(t % 10);
            t /= 10;
        }
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0')
            result.deleteCharAt(result.length() - 1);
//        // 去掉前缀的0
//        char[] a_array = result.toString().toCharArray();
//        int i = a_array.length - 1;
//        while (i > 0 && a_array[i] == '0') {
//            i--;
//        }
//        String str = "";
//        for (int j = i; j >= 0 ; j--) {
//            str += a_array[j];
//        }
        return result.reverse().toString();
    }
}
