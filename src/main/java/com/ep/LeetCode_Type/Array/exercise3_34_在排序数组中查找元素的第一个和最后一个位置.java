package com.ep.LeetCode_Type.Array;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

import java.lang.reflect.Array;
import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-27 9:54
 */
public class exercise3_34_在排序数组中查找元素的第一个和最后一个位置 {
    public static int[] searchRange(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        System.out.println(leftBorder);
        System.out.println(rightBorder);
        // 情况一
        if (leftBorder == -2 || rightBorder == -2) return new int[]{-1, -1};
        // 情况三
        if (rightBorder - leftBorder > 1) return new int[]{leftBorder + 1, rightBorder - 1};

        return new int[]{-1,-1};
    }
    // 二分查找，寻找右边界
    public static int getRightBorder(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int rightBorder = -2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
                rightBorder = low;
            }
        }
        return rightBorder;
    }
    // 二分查找，寻找左边界
    public static int getLeftBorder(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int leftBorder = -2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid -1;
                leftBorder = high;
            }else {
                low = mid + 1;
            }
        }
        return leftBorder;
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
