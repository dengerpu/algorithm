package com.ep.LeetCode_Type.Greed;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-29 9:36
 */
public class exercise9_135_分发糖果 {
    public static int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        for (int i = 0; i < candy.length; i++) {
            candy[i] = 1;
        }
        // 处理右边比左边大的情况（从前往后遍历）
        for (int i = 1; i < candy.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1] + 1;
            }
        }
        // 处理左边比右边大的情况(从后向前遍历)
        for (int i = candy.length - 1; i >= 1 ; i--) {
            // 左边比右边大，并且分发的糖果左边大于等于右边，才加
//            if (ratings[i] < ratings[i - 1] && candy[i] > candy[i-1]) {
//                candy[i - 1] = candy[i] + 1;
//            }
            // 也可以采用下面这种写法
            if (ratings[i] < ratings[i-1]) {
                candy[i - 1] = Math.max(candy[i-1], candy[i] + 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < candy.length; i++) {
            sum += candy[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1,3,4,5,2};
        System.out.println(candy(ratings));
    }
}
