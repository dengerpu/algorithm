package com.ep.LeetCode_Type.Tree;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-02 9:20
 */
public class exercise21_404_左叶子之和 {
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

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int leftValue = sumOfLeftLeaves(root.left); // 左
        int rightValue = sumOfLeftLeaves(root.right); // 右
        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) { // 判断是否是左叶子
            midValue = root.left.val;
        }

        int sum =midValue + leftValue + rightValue;
        return sum;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            }
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return sum;
    }
}
