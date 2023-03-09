package com.ep.LeetCode_Type.HashTable;

import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-09 8:58
 */
public class exercise1_242_有效的字母异位词 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                if (map.get(t.charAt(i)) == 0) return false;
                else {
                    map.put(t.charAt(i),map.get(t.charAt(i)) - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "rat", t = "car";
        System.out.println(isAnagram(s, t));
    }
}
