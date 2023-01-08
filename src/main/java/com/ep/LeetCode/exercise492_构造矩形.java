package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-08 12:29
 */
public class exercise492_构造矩形 {
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[]{area / w, w};
    }
}
