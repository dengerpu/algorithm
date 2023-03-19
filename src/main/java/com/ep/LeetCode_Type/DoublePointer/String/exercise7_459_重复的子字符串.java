package com.ep.LeetCode_Type.DoublePointer.String;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-15 9:05
 */
public class exercise7_459_重复的子字符串 {
    // 库函数
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).indexOf(s,1) != s.length();
    }
    public static boolean repeatedSubstringPattern2(String s) {
        int len = s.length();
        int[] next = new int[len];
        int j = 0;
        next[0] = 0;
        // i表示后缀末尾位置，j表示前缀末尾位置，同时也表示最长前缀长度
        for (int i = 1; i < s.length(); i++) {
            // 前后缀不相等
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j-1];
            }
            // 前后缀相等
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        if (next[len-1] != 0 && len % (len - next[len -1]) == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern2(s));
    }
}
