package com.ep.LeetCode_Type.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-10 9:10
 */
public class exercise9_90_子集II {
    static List<Integer> path = new ArrayList<>();
    static List<List<Integer>> res = new LinkedList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        backTracking(nums, 0,used);
        return res;
    }
    // 1. 确定参数和返回值
    public static void backTracking(int[] nums, int startIndex, int[] used) {
        res.add(new ArrayList<>(path));
        // 2.确定终止条件 （自己问题不需要去重）
//        if (startIndex >= nums.length) {
//            return;
//        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i-1] == 0) { // 难点：树层去重
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backTracking(nums, i+1,used);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
}
