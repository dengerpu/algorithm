package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-30 12:26
 */
public class exercise409_最长回文字符串 {
    // 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
    // 在一个回文串中，只有最多一个字符出现了奇数次，其余的字符都出现偶数次。
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            count[c] ++;
        }
        int ans = 0;
        for (int v : count) {
            ans += v/2*2; // 如果v是奇数个，就先取最大的偶数个
            if (v % 2 == 1 && ans % 2 == 0) { // v为奇数  ans为偶数
                ans++;
            }
        }
        return ans;
    }

    public static int longestPalindrome2(String s) {
        int[] count = new int[52];  // 只记录a-z A-Z
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
           if ((c <= 'z') && (c >= 'a')) {
               int key = c-'a';
               count[key]++;
           } else {
               int key = c-'A'+26;
               count[key]++;
           }
        }
        int res = 0,odd_mark = 0; // odd_mark用来标记是否有奇数个字母
        for (int i = 0; i < 52; i++) {
            res += count[i];
            if (count[i] % 2 == 1) {  // 如果是奇数个,就减去一个，并且标记一下
                res--;
                odd_mark = 1;
            }
        }
        if (odd_mark == 1) {
            res++; // 只需要加一个就行了
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "aaabbb";
        System.out.println(longestPalindrome2(s));
    }
}
