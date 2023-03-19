package com.ep.LeetCode_Type.StackAndQueue;

import java.util.Stack;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-19 8:56
 */
public class exercise1_232_用栈实现队列 {
    class MyQueue {
        Stack<Integer> stack1; // 输入栈
        Stack<Integer> stack2; // 输出栈

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            fillStack();
            return stack2.pop();
        }

        public int peek() {
            fillStack();
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        public void fillStack() {
            if (!stack2.isEmpty()) {
                return;
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }
    }
}
