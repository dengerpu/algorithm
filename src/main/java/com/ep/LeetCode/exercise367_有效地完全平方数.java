package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-25 12:17
 */
public class exercise367_有效地完全平方数 {
    public static boolean isPerfectSquare(int num) {
        int x = (int) Math.sqrt(num);
        if (x*x == num) {
            return true;
        }else {
            return false;
        }
    }
    // 方法二： 暴力破解 (会超时)
    public boolean isPerfectSquare2(int num) {
        long x = 1, square = 1;
        while (square <= num) {
            if (square == num) {
                return true;
            }
            x++;
            square = x*x;
        }
        return false;
    }

    // 方法三： 二分查找
    public boolean isPerfectSquare3(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = mid*mid;
            if (square < num) {
                left = mid+1;
            }else if (square > num){
                right = mid-1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 14;
        System.out.println(isPerfectSquare(num));
    }
}
