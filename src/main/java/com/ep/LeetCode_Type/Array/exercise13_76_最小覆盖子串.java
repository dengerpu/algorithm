package com.ep.LeetCode_Type.Array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-03 9:49
 */
public class exercise13_76_最小覆盖子串 {
//    public static String minWindow(String s, String t) {
//        int min = Integer.MAX_VALUE, left = 0, right = 0;
//        int leftIndex = 0, rightIndex = 0;  // 左右的索引
//        int s_length = s.length(), t_length = t.length();
//        if (t_length > s_length) {
//            return "";
//        }
//        for (right = 0; right < s_length; right++) {
//            if (right - left + 1 >= t_length) { // 子字符串大于t的长度再判断
//                if (containString(s.substring(left, right + 1),t)) {
//                    if (right - left + 1 < min) {
//                        min = right - left + 1;
//                        leftIndex = left;
//                        rightIndex = right;
//                    }
//                    left++;
//                }
//            }
//        }
//        return min == Integer.MAX_VALUE?"":s.substring(leftIndex, rightIndex + 1);
//    }
//    // 判断字符串中是否包含某个字符串
//    public static boolean containString(String str,String t) {
//        if (t.length() > str.length()) {
//            return false;
//        }
//        char[] chars = t.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (str.indexOf(chars[i]) == -1) {
//                return false;
//            }
//        }
//        return true;
//    }

    // 注意t可能有重复字符
    static HashMap s_map = new HashMap<Character, Integer>(); // 存储s子串中包含t字符串字符的字符频数
    static HashMap t_map = new HashMap<Character, Integer>(); // 存储t中每个字符出现的次数
    public static String minWindow(String s, String t) {
        int t_length = t.length();
        int s_length = s.length();
        if (t_length > s_length) {
            return "";
        }
        for (int i = 0; i < t_length; i++) {
            char c = t.charAt(i);
            t_map.put(c,(Integer)t_map.getOrDefault(c,0) + 1);
        }
        int leftIndex = 0, rightIndex = 0, left = 0, right = 0, min = Integer.MAX_VALUE;
        while (right < s_length) {
            if (t_map.containsKey(s.charAt(right))) {
                s_map.put(s.charAt(right), (Integer)s_map.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check() && left <= right) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    leftIndex = left;
                    rightIndex = right;
                }
                if (t_map.containsKey(s.charAt(left))) {
                    s_map.put(s.charAt(left), (Integer)s_map.getOrDefault(s.charAt(left),0) - 1);
                }
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(leftIndex, rightIndex + 1);
    }

    /**
     * 检查是否包含字符串
     * @return
     */
    public static boolean check() {
        Iterator iterator = t_map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if ((Integer)s_map.getOrDefault(key,0) < value) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
       String s = "ADOBECODEBANC", t = "ABC" ;
        System.out.println(minWindow(s, t));
    }
}
