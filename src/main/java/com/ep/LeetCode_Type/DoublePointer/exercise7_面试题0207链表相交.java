package com.ep.LeetCode_Type.DoublePointer;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-17 9:26
 */
public class exercise7_面试题0207链表相交 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    // 解法一：先求出两个链表的差，然后再一起遍历
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode pA = headA, pB = headB;
        int n = getLength(pA),m = getLength(pB);
        if (m > n) {
            for (int i = 0; i < m - n; i++) {
                pB = pB.next;
            }
        } else {
            for (int i = 0; i < n - m; i++) {
                pA = pA.next;
            }
        }
        while (pA != null && pB != null) {
            if (pA == pB) return pA;
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }
    int getLength(ListNode head) {
        int n =0;
        ListNode p = head;
        while (p!= null) {
            n++;
            p = p.next;
        }
        return n;
    }
    // 解法二：利用A+B   B+A
    // 双指针，原理：A+B 组成的链表  和 B+A组成的链表一起遍历
    // 不想交情况  m==n，遍历到各自链表末尾就会都会NULL，然后退出
    //            m≠n,遍历到m+n都会同时为NULL，然后退出
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB){
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
