package com.ep.LeetCode;

import java.util.HashSet;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-03 15:30
 */
public class exercise202_快乐数 {

    public static boolean isHappy(int n) {
        HashSet<Integer> integers = new HashSet<>();
        integers.add(n);
        while (n != 1) {
            n = result(n);
            if (integers.contains(n)) {
                return false;
            }else {
                integers.add(n);
            }
        }
        return true;
    }
    // 求各个位数平方之和
    public static int result (int n) {
        int result = 0;
        while (n != 0) {
            int a = n%10;
            result += a*a;
            n /= 10;
        }
        return result;
    }

    // 快慢指针
    public boolean isHappy2(int n) {
        int slowRunner = n;
        int fastERunner = result(n);
        while (fastERunner != 1 && slowRunner != fastERunner) {
            // 慢指针走一步，快指针走两步
            slowRunner = result(slowRunner);
            fastERunner = result(result(fastERunner));
        }
        return fastERunner == 1;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
