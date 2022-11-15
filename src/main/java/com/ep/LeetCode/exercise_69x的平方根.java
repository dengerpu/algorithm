package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 */
public class exercise_69x的平方根 {
    // 袖珍计算器算法
    public static int mySqrt(int x) {
        if (x == 0 ){
            return 0;
        }
        int ans = (int)Math.exp(0.5*Math.log(x));
        return (long)(ans +1) * (ans + 1) <= x ? ans + 1 : ans;
    }
    // 方法二： 二分查找
    public static int mySqrt1(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left +((right - left) >> 1);
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt1(x));
    }
}
