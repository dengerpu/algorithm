package com.ep.LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2022-11-29 13:43
 */
public class exercise145_二叉树的后序遍历 {
    public class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root,list);
        return list;
    }
    // 方法1 递归
    public void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return ;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }
    // 方法二： 迭代
    public List<Integer> postorderTraversal2(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if (list == null) {
            return list;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            // 左子树全部入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 这个时候root已经是等于 null
            // 最左下角元素出栈
            root = stack.pop();
            // 接下来访问右子树
            if(root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }
}
