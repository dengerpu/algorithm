package com.ep.LeetCode;

import java.util.PriorityQueue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-21 11:10
 */
public class exercise703_数据流中的第K大元素 {
    class KthLargest{
        PriorityQueue<Integer> pq;
        int k;
        public KthLargest(int k, int[] nums) {
                this.k = k;
                pq = new PriorityQueue<Integer>();
                for(int x: nums) {
                    add(x);
                }
        }
        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();
        }
    }
}
