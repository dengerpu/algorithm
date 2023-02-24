package com.ep.LeetCode;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-24 8:50
 */
public class exercise724_寻找数组的中心下标 {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2*sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
