package com.ep.LeetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-26 20:00
 */
public class exercise387_字符串中的第一个唯一字符 {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
//        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
//        for (Map.Entry entry : entries) {
//            if ((Integer) entry.getValue() == 1) {
//                return s.indexOf((char)entry.getKey());
//            }
//        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar(s));
    }
}
