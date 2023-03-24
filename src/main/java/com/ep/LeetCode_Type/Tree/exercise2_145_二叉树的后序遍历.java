package com.ep.LeetCode_Type.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-22 9:44
 */
public class exercise2_145_二叉树的后序遍历 {
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root,res);
        return res;
    }
    // 后序遍历
    public void  postorder(TreeNode root,List<Integer> res) {
        if (root == null) return;
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }

    // 后序遍历（迭代）
    public void postorderTree(TreeNode root, List<Integer> res) {
        if(root == null) return;
        TreeNode curr;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            res.add(curr.val);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        Collections.reverse(res);
    }
}
