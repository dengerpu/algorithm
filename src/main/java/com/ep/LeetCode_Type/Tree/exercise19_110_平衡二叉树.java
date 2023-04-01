package com.ep.LeetCode_Type.Tree;

import sun.reflect.generics.tree.Tree;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-01 8:57
 */
public class exercise19_110_平衡二叉树 {
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
    public boolean isBalanced(TreeNode root) {
        return getHeightDifference(root) == -1 ? false : true;
    }
    // 求左右高度之差
    public int getHeightDifference(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = getHeightDifference(node.left);
        if (leftDepth == -1) return -1;
        int rightDepth = getHeightDifference(node.right);
        if (rightDepth == -1) return -1;
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        } else {
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
