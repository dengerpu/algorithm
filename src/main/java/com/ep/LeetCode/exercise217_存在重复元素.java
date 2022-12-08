package com.ep.LeetCode;

import java.util.Arrays;
import java.util.HashSet;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-08 10:15
 */
public class exercise217_存在重复元素 {

    // 方法一  排序
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
    // 方法二：哈希表
    public static boolean containsDuplicate2(int[] nums) {
        HashSet<Object> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,0};
        System.out.println(containsDuplicate(nums));
    }
}
