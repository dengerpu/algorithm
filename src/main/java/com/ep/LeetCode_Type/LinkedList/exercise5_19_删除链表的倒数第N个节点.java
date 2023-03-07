package com.ep.LeetCode_Type.LinkedList;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-07 10:13
 */
public class exercise5_19_删除链表的倒数第N个节点 {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumyhead = new ListNode(-1); // 设置虚拟头结点
        dumyhead.next = head;
        ListNode slow = dumyhead, fast = dumyhead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dumyhead.next;
    }
}
