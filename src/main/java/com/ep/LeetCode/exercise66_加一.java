package com.ep.LeetCode;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 */
public class exercise66_加一 {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            // 找到最左边的非9
            if (digits[i] != 9) {
                ++digits[i];
                // 最后一位不是9，这个不会执行
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        int[] digist = {8,9,9};
        int [] arr = plusOne(digist);
        System.out.println(Arrays.toString(arr));
    }
}
