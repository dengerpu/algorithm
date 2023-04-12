package com.ep.LeetCode_Type.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-12 9:41
 */
public class exercise11_46_全排列 {
    static List<Integer> path;
    static List<List<Integer>> res;
    public static List<List<Integer>> permute(int[] nums) {
        path = new ArrayList<>();
        res = new LinkedList<>();
        int[] used = new int[nums.length];
        backTracking(nums, used);
        return res;
    }
    public static void backTracking(int[] nums, int[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 这种写法也可以过
//            if (path.contains(nums[i]) ) {
//                continue;
//            }
            if (used[i] == 1) continue; // 说明已经获取过了
            path.add(nums[i]);
            used[i] = 1;
            backTracking(nums, used);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }
}
