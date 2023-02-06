package com.ep.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-06 11:39
 */
public class exercise606_根据二叉树创建字符串 {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }
    //方法一： 递归
    public String tree2str(TreeNode root) {
        if(root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return Integer.toString(root.val);
        }
        if (root.right == null) {
            return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")").toString();
        }
        return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")(").append(tree2str(root.right)).append(")").toString();
    }

    // 方法二： 迭代
    public String tree2str2(TreeNode root) {
        StringBuffer ans = new StringBuffer();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        HashSet<TreeNode> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (!visited.add(node)) {
                if (node != root) {
                    ans.append(")");
                }
                stack.pop();
            } else {
                if (node != root) {
                    ans.append("(");
                }
                ans.append(node.val);
                if (node.left == null && node.right != null) {
                    ans.append("()");
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return ans.toString();
    }

}
