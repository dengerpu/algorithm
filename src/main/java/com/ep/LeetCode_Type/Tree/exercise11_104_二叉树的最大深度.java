package com.ep.LeetCode_Type.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-26 10:30
 */
public class exercise11_104_二叉树的最大深度 {
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
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left!= null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            count++;
        }
        return count;
    }
    // 深度优先遍历
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
     }
}
