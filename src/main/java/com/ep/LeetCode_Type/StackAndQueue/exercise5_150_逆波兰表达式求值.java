package com.ep.LeetCode_Type.StackAndQueue;

import java.util.Stack;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-20 9:45
 */
public class exercise5_150_逆波兰表达式求值 {
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String ch = tokens[i];
            if ("+".equals(ch) || "-".equals(ch) || "*".equals(ch) || "/".equals(ch)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int result = 0;
                switch (ch) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    case "/": result = a / b; break;
                }
                stack.push(Integer.toString(result));
            }else {
               stack.push(ch);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
}
