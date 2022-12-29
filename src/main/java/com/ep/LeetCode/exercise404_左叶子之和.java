package com.ep.LeetCode;

import java.util.LinkedList;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-29 11:03
 */
public class exercise404_左叶子之和 {
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
    // 方法一：深度优先搜索
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }
    public int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            // 如果左子树是叶子结点，就加上，否则继续向下寻找左叶子结点
            ans += isLeaveNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeaveNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    // 判断是不是叶子结点
    public boolean isLeaveNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    // 方法二： 广度优先搜索
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeaveNode(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeaveNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }
}
