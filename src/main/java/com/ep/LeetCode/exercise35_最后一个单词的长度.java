package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 */
public class exercise35_最后一个单词的长度 {
    public static int lengthOfLastWord(String s) {
        // 去掉两边的空白
        String nesString = s.trim();
        int last = nesString.length();
        for (int i = last-1; i >= 0; i--) {
            if (nesString.charAt(i)==' '){
                return last - i - 1;
            }
        }
        return last;
    }

    public static  int lengthOfLastWord1(String s) {
        int index = s.length() - 1;
        // 去掉最右边的空字符
        while (s.charAt(index) == ' ') {
            index --;
        }
        int wordLength = 0;
        while (index >=0 && s.charAt(index) != ' '){
            wordLength ++;
            index--;
        }
        return wordLength;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(lengthOfLastWord(s));
    }
}
