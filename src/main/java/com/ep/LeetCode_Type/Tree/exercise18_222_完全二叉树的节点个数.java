package com.ep.LeetCode_Type.Tree;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-31 8:55
 */
public class exercise18_222_完全二叉树的节点个数 {
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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count++;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return count;
    }
    // 深度优先搜索
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        return dfs(root);
    }
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftNum = dfs(root.left);
        int rightNum = dfs(root.right);
        return leftNum + rightNum + 1;
    }
}
