package com.ep.LeetCode_Type.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-13 10:02
 */
public class exercise12_47_全排列II {
    static List<Integer> path;
    static List<List<Integer>> res;
    public static List<List<Integer>> permuteUnique(int[] nums) {
        path = new LinkedList<>();
        res = new LinkedList<>();
        int[] used = new int[nums.length];
        Arrays.sort(nums);
        backTracking(nums, used);
        return res;
    }
    public static void backTracking(int[] nums, int[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == 0) {
                continue;
            }
            if(used[i] == 0) {
                path.add(nums[i]);
                used[i] = 1;
                backTracking(nums, used);
                used[i] = 0;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permuteUnique(nums));
    }
}
