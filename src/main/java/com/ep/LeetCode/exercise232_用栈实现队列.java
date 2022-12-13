package com.ep.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-13 10:21
 */
public class exercise232_用栈实现队列 {

    class MyQueue {

        Deque<Integer> inStack;
        Deque<Integer> outStack;

        public MyQueue() {
            inStack = new ArrayDeque<>();
            outStack = new ArrayDeque<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() &&outStack.isEmpty();
        }

        private void in2out() {
            while (! inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
