package com.ep.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-09 10:05
 */
public class exercise225_用队列实现栈 {
    // 方法一  两个队列
    class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;  // 辅助队列
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue2.offer(x);
            while (!queue1.isEmpty()) {
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

    // 方法二 一个队列
    class MyStack2 {
       /
    }
}
