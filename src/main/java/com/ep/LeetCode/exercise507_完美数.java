package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-12 17:25
 */
public class exercise507_完美数 {
    public static boolean checkPerfectNumber(int num) {
        int res = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                res += i;
            }
        }
        return num==res;
    }

    public boolean checkPerfectNumber2(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 1;
        for (int d = 2; d * d <= num ; d++) {
            if (num % d == 0) {
                sum += d;
                if (d * d < num) {
                    sum += num / d;
                }
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(7));
    }
}
