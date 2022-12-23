package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-23 11:38
 */
public class exercise345_反转字符串中的元音字母 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int left = 0, right= n -1;
        while (left < right) {
           while (left < n && !isVowel(chars[left])) {
               left++;
           }
           while (right > 0 && !isVowel(chars[right])) {
               right--;
           }
           if (left < right) {
               swap(chars,left,right);
               left++;
               right--;
           }
        }
        return new String(chars);
    }
    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
