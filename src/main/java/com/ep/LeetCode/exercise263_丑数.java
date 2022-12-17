package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-17 11:43
 */
public class exercise263_丑数 {
    public boolean isUgly(int n) {
        if( n <= 0 ) {
            return false;
        }
        int[] factors = {2,3,5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
