package com.ep.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-08 10:46
 */
public class exercise645_错误的集合 {
    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)  + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (hashMap.containsKey(i)) {
                if (hashMap.get(i) == 2) {
                    res[0] = i;
                }
            }else {
                res[1] = i;
            }
        }
        return res;
    }

    // 排序
    public int[] findErrorNums2(int[] nums) {
        int[] errorNums = new int[2];
        int n = nums.length;
        Arrays.sort(nums);
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (curr == prev) {
                errorNums[0] = prev;
            }else if (curr - prev > 1) {
                errorNums[1] = prev + 1;
            }
            prev = curr;
        }
        if (nums[n-1] != n) {
            errorNums[1] = n;
        }
        return errorNums;
    }
    // 位运算
    public int[] findErrorNums3(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int lowbit = xor & (-xor);
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & lowbit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & lowbit) == 0) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        for (int num : nums) {
            if (num == num1) {
                return new int[]{num1, num2};
            }
        }
        return new int[]{num2, num1};
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        int[] errorNums = findErrorNums(nums);
        System.out.println(Arrays.toString(errorNums));
    }
}
