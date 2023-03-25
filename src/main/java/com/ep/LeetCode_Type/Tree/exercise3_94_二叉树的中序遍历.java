package com.ep.LeetCode_Type.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-22 9:44
 */
public class exercise3_94_二叉树的中序遍历 {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }
    // 中序遍历
    public void  inorder(TreeNode root,List<Integer> res) {
        if (root == null) return;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }

    // 中序遍历（迭代）
    public void inorderTree(TreeNode root,List<Integer> res) {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) { // 指针来访问节点，访问到最底层
                stack.push(curr); // 将访问的节点放进栈
                curr = curr.left;
            } else {  // 此时已经走到了最左边的节点
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }
    }

    // 中序遍历（统一 迭代法）
    public void inorder1(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
           TreeNode node = stack.peek();
            if (node != null) {
                stack.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null); // // 中节点访问过，但是还没有处理，加入空节点做为标记。
                if (node.left != null) stack.push(node.left);
            } else {
                stack.pop(); // 将空节点弹出
                res.add(stack.pop().val); // 加入结果集
            }
        }
    }
}
