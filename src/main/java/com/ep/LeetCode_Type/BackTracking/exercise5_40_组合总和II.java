package com.ep.LeetCode_Type.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-04 10:17
 */
public class exercise5_40_组合总和II {
    static List<Integer> path;
    static List<List<Integer>> res;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        path = new ArrayList<>();
        res = new LinkedList<>();
        int[] used = new int[candidates.length];
        Arrays.sort(candidates);
        backTracking(candidates,target,0,0,used);
        return res;
    }
    // 1.确定函数返回值和参数
    static void backTracking(int[] candidates, int target, int sum, int startIndex, int[] used){
        // 2. 确定终止条件
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            // used[i - 1] == 1，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == 0，说明同一树层candidates[i - 1]使用过
            // 要对同一树层使用过的元素进行跳过
            if (i > 0 && candidates[i] == candidates[i-1] && used[i-1] == 0) { // 去重
                continue;
            }
            path.add(candidates[i]);
            used[i] = 1;
            backTracking(candidates, target, sum + candidates[i], i + 1, used);
            used[i] = 0;
            path.remove(path.size()  - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        System.out.println(lists);
    }
}
