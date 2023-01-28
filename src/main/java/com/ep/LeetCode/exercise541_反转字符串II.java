package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-28 10:09
 */
public class exercise541_反转字符串II {

    public static String reverseStr(String s, int k) {
        int length = s.length();
        int k1 = length % (2*k); // 剩余字符个数
        int end = length - k1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < end / (2*k); i++) {
            reverse(chars, 2*i*k,(2*i+1)*k-1);
        }
        if (k1 < k) { // 剩余字符小于k个，剩余字符全部反转
            reverse(chars, end, length-1);
        }else { // 反转前k个字符
            reverse(chars, end, end+k-1);
        }
        return new String(chars);
    }
    // 反转字符串
    public static void reverse( char[] s, int start, int end){
        while (start < end) {
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }
    }

    // 答案解法：
    public String reverseStr2(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2* k) {
            reverse(arr, i,Math.min(i+k, n) -1);
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }
}
