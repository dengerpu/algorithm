package com.ep.LeetCode_Type.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-26 10:43
 */
public class exercise12_111_二叉树的最小深度 {
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
    // 广度优先搜索
    public int minDepth2(TreeNode root) {
      if (root == null) return 0;
      Queue<TreeNode> queue = new ArrayDeque<>();
      queue.add(root);
      int count = 0;
      while (!queue.isEmpty()) {
          int size = queue.size();
          count++;
          for (int i = 0; i < size; i++) {
              TreeNode node = queue.poll();
              if (node.left == null && node.right == null) {
                  return count;
              } else {
                  if (node.left != null) queue.add(node.left);
                  if (node.right != null) queue.add(node.right);
              }
          }
      }
      return count;
    }

    // 深度优先搜索
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }
}
