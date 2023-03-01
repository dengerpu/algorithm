package com.ep.LeetCode_Type.Array;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-01 9:28
 */
public class exercise8_283_移动零 {
    public static void moveZeroes(int[] nums) {
       int slow = 0, fast = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                swap(nums, slow, fast);
                slow++;
            }
        }
    }
    public static void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }

    public static void main(String[] args) {
        int[]  nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
