package com.ep.lanqiao;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-04 22:36
 */
public class exercise_10_3_质数 {
    public static void main(String[] args) {
        int n = 2019;
        int count = 0;
        for (int i = 2; i <= n * n; i++) {
           if (isZhiShu(i)) {
               count++;
               if (count == 2019) {
                   System.out.println(i);
                   break;
               }
           }
        }
    }
    public static boolean isZhiShu(int n){
        if (n == 2) return true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
