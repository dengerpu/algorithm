package com.ep.LeetCode_Type.Greed;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-03 9:33
 */
public class exercise13_435_无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照左区间排序
        Arrays.sort(intervals, (a,b) -> {
            return Integer.compare(a[0],b[0]);
        });
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1][1] > intervals[i][0]){ // 重叠
                intervals[i][1] = Math.min(intervals[i-1][1], intervals[i][1]);
                count++;
            }
        }
        return count;
    }

}
