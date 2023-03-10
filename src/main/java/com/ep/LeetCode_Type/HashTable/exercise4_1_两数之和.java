package com.ep.LeetCode_Type.HashTable;

import java.util.Arrays;
import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-10 9:24
 */
public class exercise4_1_两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return new int[] {hashMap.get(nums[i]), i };
            } else {
                hashMap.put(target - nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int [] nums = {3,3};
        int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
