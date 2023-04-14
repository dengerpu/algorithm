package com.ep.LeetCode_Type.Tree;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-14 14:28
 */
public class exercise32_236_二叉树的最近公共祖先 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        if (left != null && right != null) { // 左子树出现结点p，右子树出现节点q
            return root;
        }
        if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return null;
        }

    }
}
