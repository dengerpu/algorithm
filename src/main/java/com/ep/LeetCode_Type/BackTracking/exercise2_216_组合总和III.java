package com.ep.LeetCode_Type.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-31 11:05
 */
public class exercise2_216_组合总和III {
    static List<List<Integer>> res;
    static List<Integer> path;
    public static List<List<Integer>> combinationSum3(int k, int n) {
        res = new LinkedList<>();
        path = new ArrayList<>();
        backtracking(n,k,1);
        System.out.println(res);
        return res;
    }
    // 1.确定参数和返回值
    static void backtracking(int n, int k ,int startIndex) {
        // 2.确定终止条件
        if (path.size() == k) {
            int sum = 0;
            for (int i = 0; i < path.size(); i++) {
                sum += path.get(i);
            }
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        // 回溯搜索遍历
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            if (i <= n){
                backtracking(n,k,i + 1);
            }
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 1, k = 4;
        combinationSum3(k,n);
    }
}
