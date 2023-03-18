package com.ep.LeetCode_Type.DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-18 13:18
 */
public class exercise10_18_四数之和 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int a= 0; a < n; a++) {
            // target可能为负数，所以不能只通过一个条件nums[a] > target来判断是否结束
            if (nums[a] > 0 && nums[a] > target) return lists;
            // 对a进行去重
            if (a > 0 && nums[a] == nums[a-1]) continue;
            for (int b = a + 1; b < n; b++) {
                // 对b进行去重
                if (b > a+1 && nums[b] == nums[b-1]) continue;
                int c = b + 1 , d = n - 1;
                while (c < d) {
                    long result = nums[a] + nums[b] + nums[c] + nums[d];
                    if (result > target) d--;
                    else if (result < target) c++;
                    else {
                        lists.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        // 对c进行去重
                        while (c < d && nums[c] == nums[c+1]) c++;
                        // 对d进行去重
                        while (c < d && nums[d] == nums[d-1]) d--;
                        c++;
                        d--;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};int  target = 8;
        System.out.println(fourSum(nums,target));
    }
}
