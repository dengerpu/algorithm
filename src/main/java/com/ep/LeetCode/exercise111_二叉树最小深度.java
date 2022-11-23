package com.ep.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2022-11-23 10:29
 */
public class exercise111_二叉树最小深度 {
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
    // 迭代
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 一层一层遍历
            while (size > 0) {
                TreeNode p = queue.poll();
                size--;
                // 如果p是叶子结点，直接返回
                if (p.left == null && p.right == null) {
                    return ans;
                }
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
           ans++;
        }
        return ans;
    }

    // 递归
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth1(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth1(root.right), min_depth);
        }
        return min_depth + 1;
    }
    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root,1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left,depth+1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right,depth+1));
            }

        }
        return 0;
    }
}
