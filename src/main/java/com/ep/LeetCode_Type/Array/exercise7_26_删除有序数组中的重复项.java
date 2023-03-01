package com.ep.LeetCode_Type.Array;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-01 9:20
 */
public class exercise7_26_删除有序数组中的重复项 {
    public static int removeDuplicates(int[] nums) {
        int slow = 1, fast = 0;
        for (fast = 1; fast < nums.length; fast++) {
            if (nums[slow-1] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }


    public static void main(String[] args) {
       int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
