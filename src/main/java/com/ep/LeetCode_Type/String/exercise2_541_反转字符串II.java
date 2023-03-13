package com.ep.LeetCode_Type.String;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-13 9:10
 */
public class exercise2_541_反转字符串II {
    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i+= 2*k) {
            // 少于k则i+k > n,末尾全部反转。
            // 末尾大于k则 n > i + k,只反转末尾前k个
            reverse(arr,i,Math.min(n,i+k) - 1);
        }
        return new String(arr);
    }
    // 反转字符串
    public static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg"; int k = 2;
        System.out.println(reverseStr(s, 2));
    }

}
