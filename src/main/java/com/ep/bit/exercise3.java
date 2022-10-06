package com.ep.bit;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * 例:9的二进制表示为1001，有2位是1
 */
public class exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        // 方法一
        int s = 0;
        for (int i = 0; i < 32; i++) {
            if((x&(1<<i)) == (1<<i)) {
                s ++;
            }
        }
        System.out.println(s);


        // 方法二
        System.out.println("==============");
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if(((x>>i)&1) == 1) {
                sum ++;
            }
        }
        System.out.println(sum);

        System.out.println("==============");
        // 方法三
        int count = 0;
        while (x!=0) {
            x=((x-1)&x); // 消掉一个1
            count++;
        }
        System.out.println(count);
    }
}
