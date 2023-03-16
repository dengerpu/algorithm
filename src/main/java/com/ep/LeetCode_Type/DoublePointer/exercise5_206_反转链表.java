package com.ep.LeetCode_Type.DoublePointer;

import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-16 9:56
 */
public class exercise5_206_反转链表 {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public ListNode reverseList(ListNode  head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    // 递归
    public static ListNode reverseList1(ListNode head) {
          return reverse(null, head);
    }
    public static ListNode reverse(ListNode prev, ListNode curr) {
          if (curr == null) return prev;
          ListNode temp = curr.next;
          curr.next = prev;
          return reverse(curr, temp);
    }
    
}
