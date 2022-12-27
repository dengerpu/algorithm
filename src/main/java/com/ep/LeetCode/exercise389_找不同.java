package com.ep.LeetCode;

import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-27 11:22
 */
public class exercise389_找不同 {
    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) < 0) {
                return ch;
            }
        }
        return t.charAt(0);
    }

    // 答案方法一：计数
    public char findTheDifference1(String s,String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            cnt[ch -'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }

    // 答案方法二：求和
    public char findTheDifference2(String s,String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); i++) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            at+= t.charAt(i);
        }
        return (char) (at - as);
    }

    // 答案方法三： 位运算 （转化为只出现一次的数字问题，其他都是成对出现的）
    public char findTheDifference3(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }

    public static void main(String[] args) {
        String s = "";
        String t = "y";
        System.out.println(findTheDifference(s, t));
    }
}
