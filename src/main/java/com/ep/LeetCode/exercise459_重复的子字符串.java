package com.ep.LeetCode;

import java.util.Arrays;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-03 10:26
 */
public class exercise459_重复的子字符串 {

    // 方法一 枚举
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; i++) {
            if (n % i == 0){ // n为i的倍数
                boolean match= true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j-i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
    // 方法二：字符串匹配
    public boolean repeatedSubstringPattern2(String s) {
        // 例如  abcabc   s+s = abcabcabcabc 查找第一个s出现的索引位置不应该是s的长度的位置
        return (s+s).indexOf(s,1) != s.length();
    }

    // 方法三KMP算法
    public boolean repeatedSubstringPattern3(String s) {
        return kmp(s+s, s);
    }

    public boolean kmp(String query, String pattern) {
        int n = query.length();
        int m = pattern.length();
        int[] fail = new int[m];
        Arrays.fill(fail, -1);
        for (int i = 1; i < m; i++) {
            int j = fail[i-1];
            while (j != -1 && pattern.charAt(j+1) != pattern.charAt(i)) {
                j = fail[j];
            }
            if (pattern.charAt(j+1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int match = -1;
        for (int i = 0; i < n-1; i++) {
            while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                match = fail[match];
            }
            if (pattern.charAt(match + 1) == query.charAt(i)) {
                ++match;
                if (match == m - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
