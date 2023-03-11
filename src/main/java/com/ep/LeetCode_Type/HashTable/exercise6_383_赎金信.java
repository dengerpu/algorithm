package com.ep.LeetCode_Type.HashTable;

import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-11 10:55
 */
public class exercise6_383_赎金信 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            map.put(c, map.getOrDefault(c,0) - 1);
            if (map.get(c) < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
