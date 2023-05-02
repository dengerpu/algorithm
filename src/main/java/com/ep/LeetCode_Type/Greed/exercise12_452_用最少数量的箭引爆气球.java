package com.ep.LeetCode_Type.Greed;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-05-02 9:25
 */
public class exercise12_452_用最少数量的箭引爆气球 {
    public static int findMinArrowShots(int[][] points) {
//        [[-2147483646,-2147483645],[2147483646,2147483647]]
        // 用差值比较会导致这个测试用例过不去
        Arrays.sort(points, (a, b) -> {
            // 用Integer.compare，不会溢出
            return Integer.compare(a[0],b[0]);
        });
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i-1][1]) { // 这两个气球不挨着
                count++;
            } else { // 更新重叠气球的最小右边界
                // 缩小区间 例如 [1,6],[2,8] 变为 [1,6]
                points[i][1] = Math.min(points[i-1][1],points[i][1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(findMinArrowShots(points));
    }
}
