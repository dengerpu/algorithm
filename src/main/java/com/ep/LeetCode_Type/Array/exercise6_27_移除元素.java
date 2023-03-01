package com.ep.LeetCode_Type.Array;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-28 20:46
 */
public class exercise6_27_移除元素 {
    public static int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length;
        while (left < right) { // 相当于遍历到最后
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public static int removeElement2(int[] nums, int val) {
        int slow = 0, fast = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }
}
