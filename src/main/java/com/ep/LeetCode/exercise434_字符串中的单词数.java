package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-01 12:12
 */
public class exercise434_字符串中的单词数 {
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i <s.length() ; i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
    public int countSegments2(String s) {
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        String[] a = s.split("\\s+");
        return a.length;
    }
}
