package com.ep.recursion;

/***
 * @author dep
 * @version 1.0
 * 递归基础练习
 */
public class exercise1 {
    public static void main(String[] args) {
        System.out.println(f1(5));
        f2(1,9);
        int[] arr = {1,2,3,4,5};
        System.out.println(f3(arr, 0));

        String str = "abcd";
        System.out.println(reverse(str, str.length() - 1));

        System.out.println(f4(5));

        System.out.println(gcd(12,8));
    }

    /***
     * 递归求阶乘
     * @param n
     * @return
     */
    static int f1(int n) {
        if(n == 1)
            return 1;
        return n*f1(n-1);
    }

    /***
     * 递归打印i-j
     * @param i
     * @param j
     */
    static void f2(int i, int j) {
        if(i > j) {
            return;
        }
        System.out.println(i++);
        f2(i,j);
    }

    /**
     * 递归求数组之和
     * @param arr
     * @param start
     * @return
     */
    static int f3(int[] arr, int start) {
        if(start == arr.length -1 ) {
            return arr[start];
        }
        return arr[start] + f3(arr, start+1);
    }

    /***
     * 递归翻转字符串
     * 思路: 最后一个字母加其他几个翻转
     * @param
     */
    static String reverse(String src,  int end) {
        if(end == 0) {
            return "" + src.charAt(0);
        }
        return src.charAt(end) + reverse(src, end-1);
    }

    /***
     * 斐波那契数
     * @param n
     * @return
     */
    static int f4(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }else {
            return f4(n-1) + f4(n-2);
        }
    }

    /***
     * 最大公约数
     * @param m
     * @param n
     * @return
     */
    static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        }
        return gcd(n, m % n);
    }
}
