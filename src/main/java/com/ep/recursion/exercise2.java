package com.ep.recursion;

/***
 * @author dep
 * @version 1.0
 */
public class exercise2 {
    public static void main(String[] args) {
        printHanoiTower(3,'A','B','C');
    }
    static void printHanoiTower(int n, char from, char to, char help) {
        if(n == 1) {
            // 只有一个，从A移动到B
            System.out.println("move " + n + " from " + from + " to " + to);
        }else {
            // 把A的n-1个 借助B，移动到c
            printHanoiTower(n-1, from, help, to);
            System.out.println("move " + n + " from " + from + " to " + to);
            // 再把n-1个借助A移动到B
            printHanoiTower(n-1,help, to, from);
        }
    }
}
