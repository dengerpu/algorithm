package com.ep.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-17 12:15
 */
public class exercise268_丢失的数字 {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int[] t = new int[n+1];
        for (int i = 0; i < n; i++) {
            t[nums[i]] = 1;
        }
        for (int i = 0; i < n+1; i++) {
            if (t[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    // 方法一： 排序
    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {8,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }
}
