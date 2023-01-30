package com.ep.LeetCode;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-30 11:54
 */
public class exercise561_数组拆分 {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {6,2,6,5,1,2};
        System.out.println(arrayPairSum(nums));
    }
}
