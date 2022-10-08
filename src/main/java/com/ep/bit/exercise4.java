package com.ep.bit;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * 用一条语句判断一个整数是不是2的整数次方。
 */
public class exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        if(num !=0 && ((num-1)&num) == 0) {
            System.out.println(num + "是2的整数次方");
        }
    }
}
