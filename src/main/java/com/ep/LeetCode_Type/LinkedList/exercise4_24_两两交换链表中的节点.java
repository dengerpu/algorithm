package com.ep.LeetCode_Type.LinkedList;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-07 8:59
 */
public class exercise4_24_两两交换链表中的节点 {
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
    public ListNode swapPairs(ListNode head) {
        ListNode dumyhead = new ListNode(-1); // 设置一个虚拟头结点
        dumyhead.next = head;
        ListNode curr = dumyhead;
        ListNode temp; // 保存两个结点后面的节点
        ListNode firstNode; // 临时节点。保存两个结点之中的第一个结点
        ListNode secondNode; // 临时节点，保存两个结点之中的第二个结点
        while (curr.next != null && curr.next.next != null) {
            temp = curr.next.next.next;
            firstNode = curr.next;
            secondNode = curr.next.next;
            curr.next = secondNode; // 步骤一
            secondNode.next = firstNode; // 步骤二
            firstNode.next = temp; // 步骤三
            curr = firstNode;  // cur移动，准备下一轮交换
        }
        return dumyhead.next;
    }

    // 递归
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) return head;
        // 获取当前节点的下一个结点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs2(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;
        return next;
    }

    // 不正确
    public ListNode swapPairs3(ListNode head) {
        ListNode dumyHead = new ListNode(-1);
        ListNode temp = dumyHead;
        for (int i = 0; temp.next != null ; i++,temp = temp.next) {
            if (i % 2 != 0) {
                continue;
            }
            temp.next = swap(temp.next);
        }
        return dumyHead.next;
    }
    public ListNode swap(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode temp = node.next;
        node.next = node.next.next;
        temp.next = node;
        return temp;
    }
}
