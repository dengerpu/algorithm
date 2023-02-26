package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-26 10:56
 */
public class exercise744_寻找比目标字母大的最小字母 {
    public static char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            char ch = letters[i];
            if (ch > target) {
                return ch;
            }
        }
        return letters[0];
    }

    // 二分查找
    public static char nextGreatestLetter2(char[] letters, char target) {
        int n = letters.length;
        int left = 0, right = n - 1;
        if (target >= letters[right]) {
            return letters[left];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return letters[left];
    }

    public static void main(String[] args) {
        char[] letters = {'x', 'x', 'y', 'y'};
        char target = 'z';
        System.out.println(nextGreatestLetter(letters, target));
    }
}
