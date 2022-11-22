package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-11-22 10:38
 */
public class exercise110_平衡二叉树 {
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
    // 这种会重复计算height
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }else {
            return 1 + Math.max(height(root.left),height(root.right));
        }
    }

    public boolean isBalanced1(TreeNode root) {
        return balanced(root) >= 0;
    }
    public int balanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = balanced(root.left);
        int rightHeight = balanced(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
