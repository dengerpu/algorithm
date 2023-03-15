package com.ep.LeetCode_Type.DoublePointer;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-15 9:58
 */
public class exercise1_27_移除元素 {
    public int removeElement(int[] nums, int val) {
       int slow = 0, fast = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
