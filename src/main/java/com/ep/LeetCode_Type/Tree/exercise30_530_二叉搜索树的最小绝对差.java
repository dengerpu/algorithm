package com.ep.LeetCode_Type.Tree;

import java.util.LinkedList;
import java.util.Stack;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-12 8:56
 */
public class exercise30_530_二叉搜索树的最小绝对差 {
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
//    int min = Integer.MAX_VALUE;
//    TreeNode pre;
//    public int getMinimumDifference(TreeNode root) {
//        dfs(root);
//        return min;
//    }
//    public void dfs(TreeNode node) {
//        if (node == null) return;
//        dfs(node.left);
//        if (pre != null) {
//            min = Math.min(min, node.val - pre.val);
//        }
//        pre = node;
//        dfs(node.right);
//    }

    int min;
    int pre;
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return min;
    }
    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (pre == -1) {
            pre = node.val;
        }else {
            min = Math.min(min,node.val - pre);
            pre = node.val;
        }
        dfs(node.right);
    }

    // 迭代法
    public int getMinimumDifference2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode pre = null;
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty() || curr != null) {
           if (curr != null) {
               stack.push(curr);
               curr = curr.left;
           } else {
               curr = stack.pop();
               if (pre != null) {
                   min = Math.min(min, curr.val - pre.val);
               }
               pre = curr;
               curr = curr.right;
           }
        }
        return min;
    }
}
