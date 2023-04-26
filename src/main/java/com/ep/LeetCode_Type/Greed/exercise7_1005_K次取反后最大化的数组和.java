package com.ep.LeetCode_Type.Greed;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-26 9:19
 */
public class exercise7_1005_K次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 按绝对值从大到小排列
        nums = IntStream
                .of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue)
                .toArray();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                k--;
                nums[i] = -nums[i];
            }
        }
        if (k % 2 == 1) nums[nums.length - 1] *= -1;
        int result = 0;
        for (int i : nums) {
            result += i;
        }
        return result;
    }
}
