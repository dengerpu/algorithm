package com.ep.LeetCode_Type.Array.LinkedList;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-04 10:22
 */
public class exercise1_InitLinkedList {
    public class LinkedList {
        int val; // 结点的值
        LinkedList next; // 下一个结点

        public void LinkedList() { // 结点构造函数，无参

        }

        public void LinkedList(int val) {
            this.val = val;
        }
        public void LinedList(int val , LinkedList next) {
            this.val = val;
            this.next = next;
        }
    }
}
