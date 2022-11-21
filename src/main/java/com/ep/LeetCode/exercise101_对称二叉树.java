package com.ep.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2022-11-21 9:59
 */
public class exercise101_对称二叉树 {

    public class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // 递归
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        } else if( p == null || q== null) {
            return false;
        } else {
            return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
        }
    }

    // 迭代
    public boolean isSymmetric1(TreeNode root) {
        return check1(root,root);
    }
    public boolean check1(TreeNode p,TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if ((p == null || q == null) || (p.val != q.val)) {
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.right);

            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
}
