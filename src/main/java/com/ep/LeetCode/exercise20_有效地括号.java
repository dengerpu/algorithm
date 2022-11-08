package com.ep.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/***
 * @author dep
 * @version 1.0
 */
public class exercise20_有效地括号 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * 示例 1：
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     * 输入：s = "(]"
     * 输出：false
     */

    public static boolean isValid(String s) {
            int length = s.length();
            if (length == 0) {
                return true;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if(stack.size() > 0) {
                    if (c == ')' && stack.lastElement() == '(') {
                        stack.pop();
                    }else if (c == '}' && stack.lastElement() == '{') {
                        stack.pop();
                    }else if (c == ']' && stack.lastElement() == '[') {
                        stack.pop();
                    } else {
                        // 没有匹配就入栈
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    // 官方答案
    public boolean isValid2(String s) {
        int n = s.length();
        if( n%2 == 1) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<Character, Character>(){
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        LinkedList<Character> statck = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                // 如果是右括号
                if (statck.isEmpty() || statck.peek() != map.get(ch)) {
                    return false;
                }
                statck.pop();
            }else {
                // 左括号直接入栈
                statck.push(ch);
            }
        }
        return statck.isEmpty();

    }

    public static void main(String[] args) {
        String s = "]";
        System.out.println(isValid(s));
    }
}
