package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-08 11:06
 */
public class exercise485_最大连续1的个数 {
    public static int findMaxConsecutiveOnes(int[] nums) {
       int maxCount = 0, count = 0;
       int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count ++;
            }else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
