package com.ep.LeetCode;

import java.util.Arrays;
import java.util.HashSet;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-02 10:49
 */
public class exercise575_分糖果 {
    public static int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int count = 1;
        Arrays.sort(candyType);
        for (int i = 0; i < n - 1; i++) {
            if (candyType[i] != candyType[i+1]) {
                count++;
            }
        }
        return  n / 2 <= count ? n/2 : count;
    }

    // 答案解法：
    public int distributeCandies2(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for (int candy:candyType) {
            set.add(candy);
        }
        return Math.min(set.size(),candyType.length/2);
    }
    public static void main(String[] args) {
        int[] candyType = {6,6,6,6};
        System.out.println(distributeCandies(candyType));
    }
}
