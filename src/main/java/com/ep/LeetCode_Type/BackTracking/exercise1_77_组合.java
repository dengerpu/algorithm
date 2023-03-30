package com.ep.LeetCode_Type.BackTracking;

import java.util.*;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-30 10:22
 */
public class exercise1_77_组合 {
    static List<Integer> path;
    static List<List<Integer>> res;
    public static List<List<Integer>> combine(int n, int k) {
        path = new ArrayList<>();
        res = new LinkedList<>();
        backtracking(n,k,1);
        return res;
    }
    // 1. 确定参数和返回值
    static void backtracking(int n, int k, int startIndex){
        // 2.确定终止条件
        if (path.size() == k) {
           res.add(new ArrayList<>(path));
            return;
        }
        // 3.回溯遍历搜索过程
        // 剪纸优化，之前还是 i<=n
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n,k,i+1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<List<Integer>> combine = combine(n, k);
        System.out.println(combine);
    }
}
