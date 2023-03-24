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
}
