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
}
