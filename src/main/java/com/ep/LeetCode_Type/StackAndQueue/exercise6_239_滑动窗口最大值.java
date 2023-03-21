package com.ep.LeetCode_Type.StackAndQueue;

import java.util.*;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-21 8:49
 */
public class exercise6_239_滑动窗口最大值 {
    static class MyQueue {
        Deque<Integer> deque = new LinkedList<>();
        // 弹出队列第一个元素，弹出的时候要判断要弹出的元素是否和队列头元素是都相等
        // 并且要判断是否是非空队列
        void poll (int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }
        // 添加元素，如果添加的元素大于入口处的元素，就将入口元素弹出
        // 保证队列单调递减
        // 比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
        void add (int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }
        // 队列的队顶元素始终为最大值
        int peek() {
            return deque.peek();
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) return nums;
        int len = nums.length - k + 1; //结果的长度
        int num = 0;
        int[] res= new int[len];
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            // 滑动窗口移除最前面的元素
            myQueue.poll(nums[i-k]);
            // 滑动窗口加入最后面的元素
            myQueue.add(nums[i]);
            // 记录对应的最大值
            res[num++] = myQueue.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}
