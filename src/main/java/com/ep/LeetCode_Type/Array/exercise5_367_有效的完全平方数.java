package com.ep.LeetCode_Type.Array;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-28 20:34
 */
public class exercise5_367_有效的完全平方数 {
    public static boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid > num) {
                right = mid - 1;
            } else if ((long) mid * mid < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 16;
        System.out.println(isPerfectSquare(num));
    }
}
