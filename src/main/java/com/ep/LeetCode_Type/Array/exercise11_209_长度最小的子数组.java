package com.ep.LeetCode_Type.Array;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-02 9:53
 */
public class exercise11_209_长度最小的子数组 {
    // 暴力解法,会超时
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min_Length = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    int length = j - i + 1;
                    min_Length = Math.min(length, min_Length);
                    break;
                }
            }
        }
        return min_Length == Integer.MAX_VALUE ? 0 : min_Length;
    }
    // 滑动窗口
    public static int minSubArrayLen2(int target, int[] nums) {
        int k = 0; // 窗口起始位置
        int sum = 0; // 总和
        int n = nums.length; // 数组长度
        int min_Length = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {  // 滑动窗口终止位置
            sum += nums[i];
            while (sum >= target) { // 此时已经找到了以i为起始位置的最小连续长度了
                int result = i - k + 1; // 滑动窗口的长度
                min_Length = Math.min(min_Length, result);
                sum -= nums[k++];  // 更换滑动窗口的起始位置
            }
        }
        return min_Length == Integer.MAX_VALUE  ? 0 : min_Length;
    }

    public int minSubArrayLen3(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n+1];
        // 为了方便计算，令size = n + 1 ;
        // sum[0] = 0 意味着前0个元素的前缀和为0
        // sum[1] = A[0] 前1个元素的前缀和为A[0]
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i-1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = - bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i-1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int target = 7; int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen2(target, nums));
    }
}
