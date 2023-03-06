package com.ep.LeetCode_Type.LinkedList;


/***
 * @author dep
 * @version 1.0
 * @date 2023-03-06 9:33
 */
public class exercise3_206_反转链表 {
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

    // 双指针法
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = null;
        while (curr != null) {
            temp = curr.next; // 保存下一个结点
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    // 递归写法
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode curr) {
        if (curr == null) {
            return prev;
        }
        ListNode temp = null;
        temp = curr.next; // 先保存一下节点
        curr.next = prev;
        // 更新prev,cur的位置
        // prev = curr
        // curr = temp
        return reverse(curr, temp);
    }
    // 从后向前递归
    public ListNode reverseList3(ListNode  head) {
        // 边缘条件判断
        if (head == null) return null;
        if (head.next == null) return head;

        // 递归调用，翻转第二个结点开始往后的链表
        ListNode last = reverseList3(head.next);
        // 翻转头结点与第二个结点的指向
        head.next.next = head;
        // 此时的head节点为尾结点， next需要指向NULL
        head.next = null;
        return last;
    }
}
