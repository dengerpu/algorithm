package com.ep.LeetCode_Type.String;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-14 8:38
 */
public class exercise4_151_反转字符串中的单词 {
    public static String reverseWords(String s) {
        // 去掉两端空白
        s = s.trim();
        String[] split = s.split("\\s+");
        List<String> list = Arrays.asList(split);
        Collections.reverse(list);
        return String.join(" ",list);
    }

    // 方法2 ： 1.先去掉多余的空格  2. 反转整个字符串  3. 反转每个单词
    public static String reverseWords2(String s) {
        StringBuffer stringBuffer = trimSpace(s);
        reverseString(stringBuffer, 0,stringBuffer.length()-1);
        reverseEachWords(stringBuffer);
        return stringBuffer.toString();
    }
    // 去掉字符串左右以及中间多余的单词
    public static StringBuffer trimSpace(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ')left++;
        while (left <= right && s.charAt(right) == ' ') right--;
        StringBuffer sb = new StringBuffer();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') sb.append(c);
            else if (sb.charAt(sb.length() - 1)!= ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;
    }
    // 反转整个字符串
    public static void reverseString(StringBuffer sb, int left, int right) {
        while (left < right) {
            char c = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right,c);
            left++;
            right--;
        }
    }
    // 反转每个单词
    public static void reverseEachWords(StringBuffer sb) {
        int n = sb.length();
        int start = 0,end = 0;
        while (start < n){
            while (end < n && sb.charAt(end) != ' ') end++;
            // 反转单词
            reverseString(sb,start, end-1);
            start = end + 1;
            end++;
        }
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords2(s));
    }
}
