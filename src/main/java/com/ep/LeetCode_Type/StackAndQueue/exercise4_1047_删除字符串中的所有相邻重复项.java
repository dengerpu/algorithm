package com.ep.LeetCode_Type.StackAndQueue;

import java.util.Stack;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-20 9:07
 */
public class exercise4_1047_删除字符串中的所有相邻重复项 {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
          char ch = s.charAt(i);
          if (!stack.isEmpty() && stack.peek() == ch) {
              stack.pop();
          } else {
              stack.push(ch);
          }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    // 双指针
    public static String removeDuplicates2(String s) {
        char[] ch = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while (fast < s.length()) {
            ch[slow] = ch[fast];
            if (slow > 0 && ch[slow] == ch[slow - 1]) {
                slow--;
            } else {
                slow++;
            }
            fast++;
        }
        return new String(ch,0,slow);
    }

    public static void main(String[] args) {
        String str = "aabbddcghhjj";
        System.out.println(removeDuplicates2(str));
    }
}
