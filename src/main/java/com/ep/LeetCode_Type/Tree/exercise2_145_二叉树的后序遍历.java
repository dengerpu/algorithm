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

    // 后序遍历（统一 迭代法）
    public void postorder1(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                stack.push(node);
                stack.push(null); // // 中节点访问过，但是还没有处理，加入空节点做为标记。
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            } else {
                stack.pop(); // 将空节点弹出
                res.add(stack.pop().val); // 加入结果集
            }
        }
    }
}
