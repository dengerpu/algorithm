package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-27 12:07
 */
public class exercise392_判断子序列 {
    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int n = s.length(), k = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(k) == t.charAt(i)) {
                k++;
                if (k == n) {
                    return true;
                }
            }
        }
        return false;
    }

    // 答案方法一：双指针
    public boolean isSubsequence1(String s,String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    // 答案方法二：动态规划
    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m+1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }
        for (int i = m-1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i+1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
