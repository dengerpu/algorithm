package com.ep.LeetCode_Type.Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-28 10:07
 */
public class exercise15_101_对称二叉树 {
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
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }
    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return compare(left.left,right.right) && compare(left.right, right.left);
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
          TreeNode leftNode = queue.poll();
          TreeNode rightNode = queue.poll();
          if (leftNode == null && rightNode == null) { // 左右结点为空，说明是对称的
              continue;
          }
          if (leftNode == null && rightNode != null) return false;
          else if (leftNode != null && rightNode == null) return false;
          else if (leftNode.val != rightNode.val) return false;

          queue.add(leftNode.left);
          queue.add(rightNode.right);
          queue.add(leftNode.right);
          queue.add(rightNode.left);
        }
        return true;
    }
}
