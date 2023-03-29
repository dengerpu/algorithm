package com.ep.LeetCode_Type.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-29 9:00
 */
public class exercise16_100_相同的树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
           return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
        }
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q== null) return true;
        else if (p == null || q == null) return false;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode p1 = queue1.poll();
            TreeNode p2 = queue2.poll();
            if (p1.val != p2.val) return false;
            TreeNode left1 = p1.left,right1 = p1.right,left2 = p2.left, right2 = p2.right;
            if (left1 == null ^ left2 ==null) return false;
            if (right1 == null ^ right2 == null) return false;
            if (left1 != null) queue1.offer(left1);
            if (right1 != null) queue1.offer(right1);
            if (left2 != null) queue2.offer(left2);
            if (right2 != null) queue2.offer(right2);
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

}
