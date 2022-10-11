package com.ep.recursion;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * 小白上楼梯（递归设计)
 * 小白正在上楼梯，楼梯有n阶台阶，小白一次可以上1阶，2阶或者3阶，实现一个方法，计算小白有多少种
 * 走完楼梯的方式。
 */
public class exercise3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            System.out.println(f(n));
        }
    }

    static int f(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(n == 2) return 2;
        return f(n-1) + f(n-2) + f(n-3);
    }
}
