package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 */
public class exercise27_移除元素 {

    // 方法一
    public static int removeElement(int[] nums, int val) {
       int n = nums.length;
       int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    // 方法一优化
    public static int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left <right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int len = removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

}
