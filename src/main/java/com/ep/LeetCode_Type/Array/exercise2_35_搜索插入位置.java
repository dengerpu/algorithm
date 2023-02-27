package com.ep.LeetCode_Type.Array;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-27 9:24
 */
public class exercise2_35_搜索插入位置 {
    // 二分查找
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target <= nums[mid]) {
                high = mid - 1;
            }
        }
        return low;
    }
}
