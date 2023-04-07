package com.ep.LeetCode_Type.Greed;

import java.util.HashMap;
import java.util.PriorityQueue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-07 10:51
 */
public class exercise3_53_最大子数组和 {
    public static int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result) {
                result = count;
            }
            if (count <= 0) count = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }
}
