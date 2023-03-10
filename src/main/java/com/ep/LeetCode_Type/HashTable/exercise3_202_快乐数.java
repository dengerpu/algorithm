package com.ep.LeetCode_Type.HashTable;

import java.util.HashSet;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-09 15:07
 */
public class exercise3_202_快乐数 {
    public static boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (n != 1 && !hashSet.contains(n)) {
            hashSet.add(n);
            n = result(n);
        }
        return n == 1;
    }

    public static int result(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int  n = 19;
        System.out.println(isHappy(n));
    }
}
