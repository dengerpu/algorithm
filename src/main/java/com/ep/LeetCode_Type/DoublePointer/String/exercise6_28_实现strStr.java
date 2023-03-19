package com.ep.LeetCode_Type.DoublePointer.String;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-14 10:08
 */
public class exercise6_28_实现strStr {

    // KMP算法
    public static void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        // i后缀末尾位置，j前缀末尾位置，也代表最长相等前缀长度
        for (int i = 1; i < s.length(); i++) {
            // 前后缀不相等的情况
            while (j > 0 && s.charAt(i) != s.charAt(j)) { // j要保证大于0，因为下面有取j-1作为数组下标的操作
                j = next[j-1]; // 注意这里，是要找前一位的对应的回退位置了
            }
            // 前后最相等的情况
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }

    public static  int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 &&haystack.charAt(i) != needle.charAt(j)) {
                j = next[j-1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length() ) {
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "leetcode", needle = "tc";
        System.out.println(strStr(haystack, needle));
    }
}
