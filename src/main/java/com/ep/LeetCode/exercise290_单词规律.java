package com.ep.LeetCode;

import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-19 21:35
 */
public class exercise290_单词规律 {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] strs = s.split(" ");
        int n = strs.length;
        if (n != pattern.length()) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char key = pattern.charAt(i);
            if (map.containsKey(key)) {
                if (!strs[i].equals(map.get(key))) {
                    return false;
                }
            }else {
                // 也不能包含相同的value
                if (map.containsValue(strs[i])) {
                    return false;
                }
                map.put(key, strs[i]);
            }
        }
        return true;
    }

    // 答案方法
    public boolean wordPattern2(String pattern, String str) {
        HashMap<String, Character> str2ch = new HashMap<>();
        HashMap<Character, String> ch2str = new HashMap<>();
        int m =str.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); p++) {
            char ch = pattern.charAt(p);
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && str.charAt(j) != ' ') {
                j++;
            }
            String temp = str.substring(i,j);
            if (str2ch.containsKey(temp) && str2ch.get(temp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !temp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(temp, ch);
            ch2str.put(ch, temp);
            i = j + 1;
        }
        return i >= m;
    }

    // 答案方法改进
    public boolean wordPattern3(String pattern, String s) {
        HashMap<String, Character> str2ch = new HashMap<>();
        HashMap<Character, String> ch2str = new HashMap<>();
        String[] strs = s.split(" ");
        int n = strs.length;
        if (n != pattern.length()) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            String str = strs[i];
            if (str2ch.containsKey(str) && str2ch.get(str) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !str.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(str,ch);
            ch2str.put(ch,str);
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";
        System.out.println(wordPattern(pattern, s));
    }
}
