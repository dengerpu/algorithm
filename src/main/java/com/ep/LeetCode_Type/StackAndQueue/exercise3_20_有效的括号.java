package com.ep.LeetCode_Type.StackAndQueue;

import java.util.Stack;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-19 10:00
 */
public class exercise3_20_有效的括号 {
    // 括号匹配问题
    public static boolean isValid(String s) {
        int n = s.length();
        // 奇数肯定构不成括号匹配
        if (n % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ')' || c == '}' || c == ']') { // 栈为空,且将入栈的元素为右括号
                if (stack.isEmpty()) return false;
             }
            switch (c) {
                case '(': stack.push(c); break;
                case '[': stack.push(c); break;
                case '{': stack.push(c); break;
                case ')': if (stack.peek() == '(') stack.pop(); else return false; break;
                case ']': if (stack.peek() == '[') stack.pop(); else return false;break;
                case '}': if (stack.peek() == '{') stack.pop(); else return false;break;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        int n = s.length();
        // 奇数肯定构不成括号匹配
        if (n % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // 碰到左括号就把对应的右括号入栈
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
                // 1. 栈为空，并且当前元素是右括号，则肯定不能匹配
                // 2.栈不为空，但当前右括号不能和栈中的元素匹配
            }else if (stack.isEmpty() || stack.peek() != ch) {
                return false;
            } else { // 匹配
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([])";
        System.out.println(isValid2(s));
    }
}
