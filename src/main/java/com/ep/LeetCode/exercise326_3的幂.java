package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-21 15:04
 */
public class exercise326_3的幂 {
    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 1) {
            if (n % 3 == 0) {
                n = n/3;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(isPowerOfThree(n));
    }
}
