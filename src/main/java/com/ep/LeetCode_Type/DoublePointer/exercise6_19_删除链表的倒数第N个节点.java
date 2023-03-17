package com.ep.LeetCode_Type.DoublePointer;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-17 9:13
 */
public class exercise6_19_删除链表的倒数第N个节点 {
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
        ListNode VirtualNode = new ListNode(-1); // 创建一个虚拟节点
        VirtualNode.next = head;
        ListNode slow = VirtualNode, fast = VirtualNode;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return VirtualNode.next;
    }
}
