package com.ep.LeetCode;

import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-06 10:39
 */
public class exercise205_同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) ||(t2s.containsKey(y) &&t2s.get(y) != x) ) {
                return false;
            }
            s2t.put(x,y);
            t2s.put(y,x);
        }
        return true;
    }
}
