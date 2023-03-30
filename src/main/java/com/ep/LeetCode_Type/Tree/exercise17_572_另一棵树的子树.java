package com.ep.LeetCode_Type.Tree;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-30 9:18
 */
public class exercise17_572_另一棵树的子树 {
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }
    public boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return check(root,subRoot) || dfs(root.left,subRoot) || dfs(root.right, subRoot);
    }
    public boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }else if (root == null || subRoot == null) {
            return false;
        }else if (root.val != subRoot.val) {
            return false;
        }
        return check(root.left,subRoot.left) && check(root.right, subRoot.right);
    }
}
