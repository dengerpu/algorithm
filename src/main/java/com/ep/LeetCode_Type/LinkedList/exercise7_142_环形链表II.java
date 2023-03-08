package com.ep.LeetCode_Type.LinkedList;

import java.util.HashSet;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-08 12:50
 */
public class exercise7_142_环形链表II {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // 快慢指针
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
            // 此时快慢指针已经相遇
            if (slow == fast) {
                ListNode index1 = head,index2 = slow;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    // 哈希表
    public ListNode detectCycle2(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode pos = head;
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            }else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}
