package com.ep.LeetCode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-15 10:12
 */
public class exercise242_有效的字母异位词 {
    public static boolean isAnagram(String s, String t) {
        if (s== null || t == null) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(s.charAt(i))) {
                int value = map1.get(s.charAt(i));
                value ++;
                map1.put(s.charAt(i), value);
            }else {
                 map1.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (map2.containsKey(t.charAt(i))) {
                int value = map2.get(t.charAt(i));
                value ++;
                map2.put(t.charAt(i), value);
            }else {
                map2.put(t.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key = entry.getKey();
            int value = entry.getValue();
            if (!map2.containsKey(key) || value != map2.get(key)) {
                return false;
            }
        }
        return true;
    }

    // 方法一：排序
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1, str2);
    }

    // 方法二： 哈希表
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch,table.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }
}
