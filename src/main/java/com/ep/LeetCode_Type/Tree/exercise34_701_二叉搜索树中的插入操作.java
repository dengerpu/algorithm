package com.ep.LeetCode_Type.Tree;

import sun.reflect.generics.tree.Tree;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-16 8:44
 */
public class exercise34_701_二叉搜索树中的插入操作 {
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
    // 二叉搜索树新插入的节点是叶子结点
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            root = node;
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    TreeNode parent;
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        dfs(root, val);
        return root;
    }
    public void dfs(TreeNode curr, int val) {
        if (curr == null){
            if (val > parent.val) parent.right = new TreeNode(val);
            else parent.left = new TreeNode(val);
            return;
        }
        parent = curr;
        if (val < curr.val) dfs(curr.left, val);
        if (val > curr.val) dfs(curr.right, val);
    }

    // 迭代法
    public TreeNode insertIntoBST3(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode curr = root;
        TreeNode parent = root;
        while (curr != null) {
           parent = curr;
           if (curr.val > val) curr = curr.left;
           else curr = curr.right;
        }
        if (val > parent.val) parent.right = new TreeNode(val);
        else parent.left = new TreeNode(val);

        return root;
    }
}
