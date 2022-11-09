package com.ep.LeetCode;

import org.assertj.core.internal.bytebuddy.dynamic.loading.PackageDefinitionStrategy;
import org.lanqiao.algo.elementary._09_Linear.list.ListNode;

import java.util.LinkedList;

/***
 * @author dep
 * @version 1.0
 */
public class exercise21_合并两个有序链表 {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 示例 1：
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     * 提示：
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
     */

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
      // 方法一: 递归
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }else if (list2 == null) {
                return list1;
            } else if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

        // 方法二: 暴力破解
        public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
            ListNode prehead = new ListNode(-1);

            ListNode prev = prehead;
            while(list1 != null && list2 != null) {
                if(list1.val <= list2.val) {
                    prev.next = list1;
                    list1 = list1.next;
                } else {
                    prev.next = list2;
                    list2 = list2.next;
                }
                prev = prev.next;
            }
            // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
            prev.next = list1 == null ? list2 : list1;
            return prehead.next;
        }
}
