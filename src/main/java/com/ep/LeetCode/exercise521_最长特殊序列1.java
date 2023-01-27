package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-15 19:04
 */
public class exercise521_最长特殊序列1 {
    public int findLUSlength(String a, String b) {
        return !a.equals(b) ? Math.max(a.length(), b.length()) : -1;
    }
}
