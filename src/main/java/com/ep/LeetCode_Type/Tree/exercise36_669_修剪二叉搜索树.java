package com.ep.LeetCode_Type.Tree;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-19 9:13
 */
public class exercise36_669_修剪二叉搜索树 {
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) { // 此时root,以及root的左子树都是要删除的结点
            // 不能直接return root.right (因为右子树也可能存在比low小的)
            TreeNode right = trimBST(root.right, low, high);
            return right;
        }
        if (root.val > high) {
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) return null;

        // 处理头结点，让root到[L,R]范围内
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) root = root.right;
            else root = root.left;
        }
        TreeNode curr = root;
        // 此时root已经在[L, R] 范围内，处理左孩子元素小于L的情况
        while (curr != null) {
            while (curr.left != null && curr.left.val < low) {
                curr.left = curr.left.right;
            }
            curr = curr.left;
        }
        curr = root;
        // 此时root已经在[L, R] 范围内，处理右孩子大于R的情况
        while (curr != null) {
            while (curr.right != null && curr.right.val > high) {
                curr.right = curr.right.left;
            }
            curr = curr.right;
        }
        return root;
    }

}
