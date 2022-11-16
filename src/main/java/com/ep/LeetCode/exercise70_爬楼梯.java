package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 */
public class exercise70_爬楼梯 {
    // 会超时时间限制
    public static int climbStairs(int n) {
        if(n == 1) {
            return 1;
        } else if (n == 2 ){
            return 2;
        }else {
            // n-1代表最后一步是一步，n-2代表最后一步是两步
            return climbStairs(n-1) + climbStairs(n-2);
        }
    }
    public static int climbStairs2(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs2(n));
    }
}
