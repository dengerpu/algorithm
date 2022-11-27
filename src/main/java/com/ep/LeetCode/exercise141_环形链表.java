package com.ep.LeetCode;

import java.util.HashSet;

/***
 * @author dep
 * @version 1.0
 * @date 2022-11-27 10:38
 */
public class exercise141_环形链表 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
  public boolean hasCycle(ListNode head) {
      HashSet<ListNode> listNodes = new HashSet<>();
      while (head != null) {
          // add会先判断存不存在该元素
          if (!listNodes.add(head)) {
              return true;
          }
          head = head.next;
      }
      return false;
  }

  // 双向链表
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next  == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            // 慢指针移动一步，快指针移动两步
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
