package com.ep.LeetCode;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-08 10:07
 */
public class exercise643_子数组最大平均数I {
    // 会超出内存限制
    public static double findMaxAverage(int[] nums, int k) {
        Double max = new Double(Integer.MIN_VALUE);
        for (int i = 0; i < nums.length - k + 1; i++) {
            Double sum = 0.0;
            for (int j = i; j < i+k; j++) {
                sum += nums[j];
            }
            if (sum / k > max) {
                max = sum / k;
            }
        }
        return max;
    }
    // 答案解法：滑动窗口
    public double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0*maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        int k = 1;
        System.out.println(findMaxAverage(nums, k));
    }
}
