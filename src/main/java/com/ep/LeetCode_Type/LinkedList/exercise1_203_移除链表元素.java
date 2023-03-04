package com.ep.LeetCode_Type.LinkedList;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-04 10:29
 */
public class exercise1_203_移除链表元素 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
      // 可以设置一个虚拟头结点，这样原链表的所有节点就都可以按照统一的方式进行移除了。
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
         // 设置一个虚拟头结点
        ListNode newHead = new ListNode(-1, head);
        ListNode pre = newHead, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return newHead.next;
    }

    // 不添加虚拟节点
    public ListNode removeElements2(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode newHead = head, node = head; // 此时的头结点为去掉相同值的头结点
        while (node != null) {
            while (node.next != null && node.next.val == val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return newHead;
    }

    public static void main(String[] args) {

    }
}
