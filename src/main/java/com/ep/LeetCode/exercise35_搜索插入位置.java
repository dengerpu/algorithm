package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 */
public class exercise35_搜索插入位置 {
    public static int searchInsert(int[] nums, int target) {
        // 二分查找
        int left = 0, right = nums.length - 1 ;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums,target));
    }
}
