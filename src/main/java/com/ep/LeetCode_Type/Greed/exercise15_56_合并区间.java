package com.ep.LeetCode_Type.Greed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-05 12:41
 */
public class exercise15_56_合并区间 {
    public static int[][] merge(int[][] intervals) {
        // 按左区间排序
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        List<int[]> result = new LinkedList<>();
        int start = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) { // 左边界小于等于右边界，说明可以合并
                right = Math.max( right, intervals[i][1]);
            } else {
                result.add(new int[]{start, right});
                start = intervals[i][0];
                right = intervals[i][1];
            }
        }
        result.add(new int[]{start, right});
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{4,5}};
        System.out.println(intervals.toString());
    }
}
