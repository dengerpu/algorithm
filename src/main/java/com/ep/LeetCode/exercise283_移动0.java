package com.ep.LeetCode;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-18 21:53
 */
public class exercise283_移动0 {
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            if (nums[i] == 0) {
                if (!IsZero(nums,i)) { // 如果后面不是全都都是零
                    int t = nums[i];
                    for (int j = i; j < n -1 ; j++) {
                        nums[j] = nums[j+1];
                    }
                    nums[n-1] = t;
                    i = -1;  // 需要重头再开始
                }
            }
        }
    }
    // 判断是不是全为0
    public static Boolean IsZero(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // 答案解法
    public void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums,left, right);
                left++;
            }
            right++;
        }
    }
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
