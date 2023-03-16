package com.ep.LeetCode_Type.DoublePointer;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-16 9:30
 */
public class exercise4_151_反转字符串中的单词 {
    // 思路： 1.去掉两端空格以及中间多余的空格，2.反转整个字符串 3. 反转每一个单词
    public static String reverseWords(String s) {
        StringBuffer sb = trimSpace(s);
        int n = sb.length();
        reverseString(sb,0, n-1);
       reverseEachWords(sb);
       return sb.toString();

    }
    // 去掉两端的空格,以及中间的空格
    public static StringBuffer trimSpace(String str) {
        int i = 0, j = str.length() - 1;
        StringBuffer sb = new StringBuffer();
        while (str.charAt(i) == ' ') i++;
        while (str.charAt(j) == ' ') j--;
        while (i <= j) {
            if (str.charAt(i) != ' ') sb.append(str.charAt(i));
            else if (sb.charAt(sb.length() -1) != ' ') {
                sb.append(str.charAt(i));
            }
            i++;
        }
        return sb;
    }
    // 反转字符串
    public static void reverseString(StringBuffer sb, int left, int right) {
        while (left < right) {
            char c = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, c);
            left++;
            right--;
        }
    }

    public static void reverseEachWords(StringBuffer sb){
        int start = 0;
        int end = 0;
        int n = sb.length();
        while (end < n) {
            while (end < n && sb.charAt(end) != ' ') end ++;
            reverseString(sb,start, end - 1);
            start = end+1;
            end++;
        }
    }

    public static void main(String[] args) {
        String str = "  hello world  ";
        System.out.println(reverseWords(str));
    }
}
