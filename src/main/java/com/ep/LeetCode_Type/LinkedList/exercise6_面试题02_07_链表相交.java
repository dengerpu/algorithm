package com.ep.LeetCode_Type.LinkedList;

import java.util.HashMap;
import java.util.HashSet;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-08 8:43
 */
public class exercise6_面试题02_07_链表相交 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 使用两个指针，从长度相同的位置开始比较
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode newHeadA = headA,newHeadB = headB, currA = headA, currB = headB;
       int count1 = 0, count2 = 0, n = 0; // n代表长的链表指针需要移动的步数
       while (newHeadA != null) { // 计算链表A的长度
           count1++;
           newHeadA = newHeadA.next;
       }
       while (newHeadB != null) {
           count2++;
           newHeadB = newHeadB.next;
       }
       if (count1 >= count2) {
           n = count1 - count2;
           for (int i = 0; i < n; i++) {
                currA = currA.next;
           }
       }else {
           n = count2 - count1;
           for (int i = 0; i < n; i++) {
               currB = currB.next;
           }
       }
       while (currA!= null && currB!= null) {
           if (currA == currB) return currA;
           currA = currA.next;
           currB = currB.next;
       }
        return null;
    }

    // 使用哈希集合
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode node = headA;
        while (node != null) {
            visited.add(node);
            node = node.next;
        }
        node = headB;
        while (node != null) {
            if (visited.contains(node)) return node;
            node = node.next;
        }
        return null;
    }

    // 双指针，原理：A+B 组成的链表  和 B+A组成的链表一起遍历
    // 不想交情况  m==n，遍历到各自链表末尾就会都会NULL，然后退出
    //            m≠n,遍历到m+n都会同时为NULL，然后退出
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB){
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) { //遍历到最后如果没有相交，两者都会为NULL人，相等退出
            pA = pA==null?headB:pA.next;
            pB = pB==null?headA:pB.next;
        }
        return pA;
    }
}
