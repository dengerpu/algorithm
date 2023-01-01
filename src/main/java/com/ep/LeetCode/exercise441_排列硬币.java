package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-01 15:46
 */
public class exercise441_排列硬币 {
    // 方法一 二分查找
    // 等差数列求和公式 s = n*(n+1)/2
    public static int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1 )/ 2 + left;
            if ((long)mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(6));
    }
}
