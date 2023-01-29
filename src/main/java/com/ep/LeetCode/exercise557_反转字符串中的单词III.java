package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-29 10:21
 */
public class exercise557_反转字符串中的单词III {
    
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, j, i-1);
                j = i+1;
            }
        }
        // 只有一个单词时候的逆转和最后一个单词的逆转
        if (j == 0 || j < chars.length) {
            reverse(chars, j, chars.length-1);
        }
        return new String(chars);
    }
    public static void reverse(char[] s, int left, int right) {
        while (left < right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }

    // 答案解法一： 使用额外空间
    public String reverseWords2(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            // 逆序添加
            for (int j = start; j < i; j++) {
                ret.append(s.charAt(start + i -1 - j));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "God Ding";
        System.out.println(reverseWords(s));
    }
}
