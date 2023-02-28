package com.ep.LeetCode_Type.Array;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-28 20:21
 */
public class exercise4_69_x的平方根 {
    public static int mySqrt(int x) {
        int left = 0, right = x;
        int ans = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if ((long)mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(mySqrt(x));
    }
}

