package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-15 11:45
 */
public class exercise696_计数二进制子串 {
    public int countBinarySubstrings(String s) {
        int ptr =0, n = s.length(), last = 0, ans = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ptr++;
                count++;
            }
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }
}
