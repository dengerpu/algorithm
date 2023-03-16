package com.ep.LeetCode_Type.DoublePointer;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-16 9:14
 */
public class exercise3_剑指Offer05_替换空格 {
    public static String replaceSpace(String s) {
        if (s.length() == 0 || s == null) return s;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            // 有空格，就将空格扩容三倍
            if (s.charAt(i) == ' ') sb.append("  ");
        }
        // 没有空格就直接返回
        if (sb.length() == 0) return s;
        int left = s.length() - 1; // 左指针指向原始字符串的最后一个位置
        s+=sb.toString();
        int right = s.length() -1; // 右指针指向扩容两倍空格字符串的最后一个位置
        char[] chars = s.toCharArray();
        while (left >= 0) {
            if (chars[left] == ' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            } else {
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(replaceSpace(str));
    }
}
