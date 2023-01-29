package com.ep.LeetCode;

import sun.awt.AWTAccessor;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-29 10:00
 */
public class exercise551_学生出勤记录I {
    public static boolean checkRecord(String s) {
        int A_count = 0;
        int L_count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                A_count++;
            }
            if (A_count >= 2) {
                return false;
            }
            if (i < s.length() -1 && s.charAt(i) == s.charAt(i+1) && s.charAt(i) == 'L') {
                L_count++;
            }else {
                L_count = 0;
            }
            if (L_count >= 2) {
                return false;
            }
        }
        return true;
    }

    // 答案解法：
    public boolean checkRecord2(String s) {
        int absents = 0, lates = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                absents++;
                if (absents >= 2) {
                    return false;
                }
            }
            if (c == 'L') {
                lates ++;
                if (lates >= 3) {
                    return false;
                }
            }else {
                lates = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "LLALL";
        System.out.println(checkRecord(s));
    }
}
