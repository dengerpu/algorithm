package com.ep.LeetCode_Type.BackTracking;

import java.util.*;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-11 10:14
 */
public class exercise10_491_递增子序列 {
    static List<Integer> path;
    static List<List<Integer>> res;
    public static List<List<Integer>> findSubsequences(int[] nums) {
        path = new ArrayList<>();
        res = new LinkedList<>();
        backTracking(nums,0);
        return res;
    }

//    -100 <= nums[i] <= 100
    public static void backTracking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
//        HashMap<Integer, Integer> used = new HashMap<>();
        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
//            if(path.size() > 0 && nums[i] < path.get(path.size() - 1) || used.getOrDefault(nums[i], 0) >= 1) {
//                continue;
//            }
//            used.put(nums[i], used.getOrDefault(nums[i],0) + 1); // 不用回溯，只记录本层递归中是否有重复的
            if (path.size() > 0 && nums[i] < path.get(path.size() - 1) || used[nums[i] + 100] == 1) {
                continue;
            }
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums ={4,6,7,7};
        System.out.println(findSubsequences(nums));
    }
}
