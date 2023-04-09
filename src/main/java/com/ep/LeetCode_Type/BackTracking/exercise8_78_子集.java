package com.ep.LeetCode_Type.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-09 10:04
 */
public class exercise8_78_子集 {
    static List<Integer> path;
    static List<List<Integer>> res;
    public static List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        if (nums.length == 0) {
            res.add(new ArrayList<>(path));
            return res;
        }
        backTracking(nums, 0);
        return res;
    }
    // 子集问题与组合问题的区别，组合问题只需要在叶子结点收集结果，而子集节点每层都要收集结果
    public static void backTracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
//        // 终止条件 (这里可以不用写), 因为startIndex >= nums.length之后下面的for循环就不会执行了
//        if (startIndex >= nums.length) {
//            return;
//        }
        // 遍历搜索
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums,i+1);
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }
}
