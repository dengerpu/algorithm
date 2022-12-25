package com.ep.LeetCode;

import java.util.Random;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-25 12:37
 */
public class exercise374_猜数字大小 {
    public static int guess(int num){
//        return (int)(Math.random()*(num) + 1);
        return -1; // -1小，1大， 0 相等
    }
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int pick = guess(mid);
            if (pick < 0) {
                right = mid-1;
            } else if(pick > 0) {
                left = mid+1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
