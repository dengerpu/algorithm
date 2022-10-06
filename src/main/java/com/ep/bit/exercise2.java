package com.ep.bit;

/***
 * @author dep
 * @version 1.0
 * 一个数组里除了某一个数字之外，其他的数字都出现了两次。请写程序找出这个只出现一次的数字。
 */
public class exercise2 {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,5,4,5,0,0,10};
        int x1 = 0;
        for (int i = 0; i < arr.length; i++) {
            x1 = x1^arr[i];
        }
        System.out.println(x1);
    }
}
