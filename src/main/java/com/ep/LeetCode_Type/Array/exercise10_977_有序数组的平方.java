package com.ep.LeetCode_Type.Array;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-01 13:14
 */
public class exercise10_977_有序数组的平方 {
    // 时间复杂度o(nlog(n))
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i] * nums[i];
        }
        Arrays.sort(arr);
        return arr;
    }
     public static int[] sortedSquares2(int[] nums) {
         int n = nums.length;
         int[] arr = new int[n];
         int left = 0, right = n - 1, k = n - 1;
         while (left <= right) {
             int left_val = nums[left] * nums[left];
             int right_val = nums[right] * nums[right];
            if (left_val <= right_val) {
                arr[k--] = right_val;
                right--;
            }else {
                arr[k--] = left_val;
                left++;
            }
         }
         return arr;
     }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] arr = sortedSquares2(nums);
        System.out.println(Arrays.toString(arr));
    }

}
