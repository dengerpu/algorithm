package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-21 14:28
 */
public class exercise303_区域和检索_数组不可变 {
    // 方法一：前缀和
    class NumArray {
        int[] sums;

        public NumArray(int[] nums) {
            int n = nums.length;
            sums = new int[n+1];
            for (int i = 0; i < n; i++) {
                sums[i+1] = sums[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j+1] - sums[i];
        }
    }
}
