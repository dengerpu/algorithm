package com.ep.AcWing;

import java.util.Arrays;
import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-07 10:34
 */
public class AcWing792_高精度减法 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String a = scanner.next();
//        String b = scanner.next();
//        char[] a_array = new char[a.length()];
//        char[] b_array = new char[b.length()];
//        int j = 0;
//        for (int i = a.length() - 1; i >= 0 ; i--) {
//            a_array[j++] = a.charAt(i);
//        }
//        j = 0;
//        for (int i = b.length() - 1; i >= 0 ; i--) {
//            b_array[j++] = b.charAt(i);
//        }
//        System.out.println(Arrays.toString(a_array));
//        System.out.println(Arrays.toString(b_array));
        char[] a_array = new StringBuffer(scanner.next()).reverse().toString().toCharArray();
        char[] b_array = new StringBuffer(scanner.next()).reverse().toString().toCharArray();
        System.out.println(sub(a_array, b_array));
    }
    public static String sub(char[] a, char[] b) {
        if (!cmp(a,b)) return "-" + sub(b,a);
        int t = 0,result = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < a.length; i++) {
            result = a[i] - '0' - t;
            if (i < b.length) {
                result -= (b[i] - '0');
            }
            if (result < 0) t = 1;
            else t = 0;
            result = (result + 10) % 10;
            stringBuffer.append(result);
        }
        //要去掉前缀的0
        char[] chars = stringBuffer.toString().toCharArray();
        int i = chars.length - 1;
        while (i >= 1 && chars[i] == '0') {
            i--;
        }
        String str = "";
        for (int j = i; j >= 0; j--) {
            str += chars[j];
        }
        return str;
    }

    /**
     * 比较两个数的大小
     * @param a 正整数
     * @param b 正整数
     * @return
     */
    public static boolean cmp(char[] a, char[] b) {
        if (a.length != b.length) return a.length > b.length;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] != b[i]) return a[i] > b[i];
        }
        return true;
    }
}
