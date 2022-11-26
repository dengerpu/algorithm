package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-11-26 11:03
 */
public class exercise125_验证回文字符串 {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) {
            return true;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (48 <= c && c <= 57) { // 数字
                stringBuffer.append(c);
            }else if (65 <= c && c <= 90) { // 大写字母
                char a = (char)(c+32);
                stringBuffer.append(a);
            } else if (97 <= c && c <=122) { // 小写字母
                stringBuffer.append(c);
            } else {
                continue;
            }
        }
        if (stringBuffer.toString().equals(stringBuffer.reverse().toString())) {
            return true;
        } else {
            return false;
        }
    }

    // 答案方法1
    public boolean isPalindrome2(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stringBuffer.append(Character.toLowerCase(ch));
            }
        }
        return  stringBuffer.toString().equals(stringBuffer.reverse().toString());
    }

    // 答案方法2 双指针
    public boolean isPalindrome3(String s) {
        int n = s.length();
        int left = 0, right = n-1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
