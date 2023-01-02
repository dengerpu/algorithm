package com.ep.LeetCode;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-02 12:18
 */
public class exercise455_分发饼干 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int Glength = g.length,Slength = s.length,i=0,j=0;
        int count = 0;
        while (i < Glength && j < Slength) {
            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            }else {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        System.out.println(findContentChildren(g, s));
    }
}
