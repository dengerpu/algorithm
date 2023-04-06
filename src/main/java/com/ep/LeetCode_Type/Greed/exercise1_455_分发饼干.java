package com.ep.LeetCode_Type.Greed;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-06 10:41
 */
public class exercise1_455_分发饼干 {
    public static int findContentChildren(int[] g, int[] s) {
        int i = 0, j = 0;
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count ++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        // 7,8,9,10
        int[] s = {5,6,7,8};
        System.out.println(findContentChildren(g, s));
    }

}
