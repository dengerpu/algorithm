package com.ep.bit;

import java.util.Scanner;

/***
 * @author dep
 * @version 1.0
 * 将整数的奇偶位互换
 */
public class exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(swap(num));

    }
    public static int swap(int num) {
        int odd = num&0x55555555; // 和0101 0101 0101 0101 ...相与取出奇数位   // 原本的偶数位
        int even = num&0xaaaaaaaa; // 和1010 1010 1010 1010...相与取出偶数位    // 原本的奇数位
        return (odd<<1)^(even>>1); //连起来  (0与任何数异或得到的是本身)
    }
}
