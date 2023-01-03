package com.ep.LeetCode;

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

}
