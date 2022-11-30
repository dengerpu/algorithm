package com.ep.LeetCode;

import java.util.HashSet;

/***
 * @author dep
 * @version 1.0
 * @date 2022-11-30 10:34
 */
public class exercise160_相交链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 哈希表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while(temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // 双指针  原理，就相当于遍历完遍历完A，在遍历B。 遍历完B再遍历A。两者相交之处在同一个位置
    // 例如 A  1 3 5
    //      B  4 3 5
    // 遍历完A，在遍历B  1 3 5 4 3 5
    // 遍历完B再遍历A    4 3 5 1 3 5
    // 也就是说相交，相交的部位是相同的。  则A+B   B+A长度相同，且最后几位都是相交的部位
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while(pA != pB) {
           if (pA == null) {
               pA = headB;
           } else {
               pA = pA.next;
           }
           if (pB == null) {
               pB = headA;
           } else {
               pB= pB.next;
           }
        }
        return pA;
    }
}
