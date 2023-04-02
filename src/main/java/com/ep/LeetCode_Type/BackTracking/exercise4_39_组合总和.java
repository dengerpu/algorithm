package com.ep.LeetCode_Type.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-02 11:01
 */
public class exercise4_39_组合总和 {
    static List<Integer> path;
    static List<List<Integer>> res;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        path = new ArrayList<>();
        res = new LinkedList<>();
        Arrays.sort(candidates);
        backTracking(candidates, target,0,0);
        return res;
    }

    // 1. 确定返回值和参数
    static void backTracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) return;
        // 2. 确定终止条件
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 3.回溯遍历搜索过程
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            sum += candidates[i];
            backTracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] candidates = {8,7,4,3}; int target = 11;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println(lists);
    }
}
