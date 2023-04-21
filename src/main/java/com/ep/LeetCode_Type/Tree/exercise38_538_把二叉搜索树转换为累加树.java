package com.ep.LeetCode_Type.Tree;

import java.util.Stack;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-21 9:16
 */
public class exercise38_538_把二叉搜索树转换为累加树 {
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
    int pre = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    public void dfs(TreeNode root) { // 右中左遍历
        if (root == null) return;
        dfs(root.right);
        root.val += pre;
        pre = root.val;
        dfs(root.left);
    }

    // 迭代法(中序的迭代法)
    public TreeNode convertBST2(TreeNode root) {
        if (root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int pre = 0;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr); // 右
                curr = curr.right;
            } else {
                curr = stack.pop(); // 中
                curr.val += pre;
                pre = curr.val;

                curr = curr.left; //左
            }
        }
        return root;
    }
}
