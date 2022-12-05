package com.ep.LeetCode;

import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-05 21:31
 */
public class exercise203_移除链表元素 {
    
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      // 方法一  递归
      public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
      }

      // 方法二 迭代
      public ListNode removeElements2(ListNode head, int val) {
          ListNode dummyHead = new ListNode(0);
          dummyHead.next = head;
          ListNode temp = dummyHead;
          while (temp.next != null) {
              if (temp.next.val == val) {
                  temp.next = temp.next.next;
              } else {
                  temp = temp.next;
              }
          }
          return dummyHead.next;

      }
    
}
