package com.ep.LeetCode;

import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-26 19:31
 */
public class exercise383_赎金信 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length() ) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            Integer value = map.getOrDefault(ch, 0) + 1;
            map.put(ch, value);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    // 答案方法：字符统计
    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c-'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aba";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
