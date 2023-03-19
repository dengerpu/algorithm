package com.ep.LeetCode_Type.StackAndQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-19 9:22
 */
public class exercise2_225_用队列实现栈 {
    class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;
        public MyStack() {
           queue1 = new LinkedList<>();
           queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue2.offer(x);
            while (!queue1.isEmpty()) { //队列1不为空
                queue2.offer(queue1.poll());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        public int pop() {
           return queue1.poll();
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    class MyStack2 {
        Queue<Integer> queue1;
        public MyStack2() {
            queue1 = new LinkedList<>();
        }

        public void push(int x) {
            int n = queue1.size();
            queue1.offer(x);
            for (int i = 0; i < n; i++) { //将前面的数插到后面
                queue1.offer(queue1.poll());
            }
        }

        public int pop() {
            return queue1.poll();
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}
