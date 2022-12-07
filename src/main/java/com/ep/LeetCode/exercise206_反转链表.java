package com.ep.LeetCode;

import java.util.*;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-07 10:10
 */
public class exercise206_反转链表 {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     // 初始化链表
    public static ListNode initList(int[] head) {
        ListNode listNode = new ListNode();
        ListNode p = new ListNode();
        p = listNode;
        for (int i = 0; i < head.length; i++) {
            ListNode q = new ListNode();
            q.val = head[i];
            q.next = null;
            p.next = q;
            p = q;
        }
        return listNode.next;
    }
    // 打印链表
    public static void printList(ListNode head) {
         ListNode p = head;
        ArrayList<Integer> list = new ArrayList<>();
        while (p != null) {
             list.add(p.val);
             p = p.next;
         }
        System.out.println(list.toString());
    }

     public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p!= null) {
            stack.push(p);
            p = p.next;
        }
        ListNode listNode = new ListNode();
        ListNode l = listNode;
        int n = stack.size();
         for (int i = 0; i < n; i++) {
             ListNode q = stack.pop();
             q.next = null;
             l.next = q;
             l = q;
         }
         return listNode.next;
     }

     // 方法一  迭代
    public ListNode reverseList2 (ListNode head) {
         ListNode prev = null;
         ListNode curr = head;
         while(curr != null) {
             ListNode next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
         }
         return prev;
    }

    // 方法二 递归
    /**
     * 以链表1->2->3->4->5举例
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
              /*
                直到当前节点的下一个节点为空时返回当前节点
                由于5没有下一个节点了，所以此处返回节点5
             */
            return head;
        }
        //递归传入下一个节点，目的是为了到达最后一个节点
        // 返回的始终是原链表的最后一个结点
        ListNode newHead = reverseList(head.next);
         /*
            第一轮出栈，head为5，head.next为空，返回5
            第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
                      把当前节点的子节点的子节点指向当前节点
                      此时链表为1->2->3->4<->5，由于4与5互相指向，所以此处要断开4.next=null
                      此时链表为1->2->3->4<-5
                      返回节点5
            第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
                      此时链表为1->2->3<->4<-5，由于3与4互相指向，所以此处要断开3.next=null
                      此时链表为1->2->3<-4<-5
                      返回节点5
            第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
                      此时链表为1->2<->3<-4<-5，由于2与3互相指向，所以此处要断开2.next=null
                      此时链表为1->2<-3<-4<-5
                      返回节点5
            第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
                      此时链表为1<->2<-3<-4<-5，由于1与2互相指向，所以此处要断开1.next=null
                      此时链表为1<-2<-3<-4<-5
                      返回节点5
            出栈完成，最终头节点5->4->3->2->1
         */
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
         int[] head = {1,2,3,4,5};
        ListNode listNode = initList(head);
        printList(listNode);
        ListNode listNode1 = reverseList(listNode);
        printList(listNode1);

    }

}
