package com.ep.LeetCode_Type.LinkedList;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-05 9:07
 */
public class exercise2_707_设计链表 {
    // 单链表
    class MyLinkedList {

        class ListNode {
            int val;
            ListNode next;
            public  ListNode(int val) {
                this.val = val;
            }
        }

        int size;
        ListNode head;

        // 初始化链表
        public MyLinkedList() {
            head = new ListNode(0);
            head.next = null;
            size = 0;
        }

        // 获取第index个索引
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            int count = 0;
            ListNode node = head.next;
            while (node != null) {
                if (count == index) return node.val;
                node = node.next;
                count ++;
            }
            return -1;
        }

        // 添加元素到头部
        public void addAtHead(int val) {
           addAtIndex(0,val);
        }

        // 添加元素到尾部
        public void addAtTail(int val) {
            addAtIndex(size,val);
        }

        // 添加元素
        public void addAtIndex(int index, int val) {
            if(index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            ListNode prev = head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            ListNode listNode = new ListNode(val);
            listNode.next = prev.next;
            prev.next = listNode;
            size++;
        }

        // 删除元素
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            if (index == 0) {
                head = head.next;
                return;
            }
            ListNode prev = head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
        }
    }
    // 双链表
    class MyLinkedList2 {

        class ListNode {
            int val;
            ListNode next;
            ListNode prev;
            public  ListNode(int val) {
                this.val = val;
            }
        }

        int size;
        ListNode head;
        ListNode tail;

        // 初始化链表
        public MyLinkedList2() {
            head = new ListNode(0);
            tail = new ListNode(0);
            size = 0;
            tail.prev = head;
            head.next = tail;
        }

        // 获取第index个索引
        public int get(int index) {
            if(index < 0 || index >= size)  return -1;
            // 判断从哪一边开始遍历短
            if (index >= size / 2) {
                // 从后往前开始遍历
                ListNode cur = tail;
                for (int i = 0; i < size - index; i++) {
                    cur = cur.prev;
                }
                return cur.val;
            } else {
                // 从前往后遍历
                ListNode cur = head.next;
                for (int i = 0; i < index; i++) {
                    cur = cur.next;
                }
                return cur.val;
            }
        }

        // 添加元素到头部
        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        // 添加元素到尾部
        public void addAtTail(int val) {
            addAtIndex(size,val);
        }

        // 添加元素
        public void addAtIndex(int index, int val) {
            if (index > size) return;
            if (index < 0) index = 0;
            ListNode cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            ListNode listNode = new ListNode(val);
            listNode.next = cur.next;
            cur.next.prev = listNode;
            cur.next = listNode;
            listNode.prev = cur;
            size++;
        }

        // 删除元素
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            size--;
            ListNode curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            curr.next.next.prev = curr;
            curr.next = curr.next.next;

        }
    }
}
