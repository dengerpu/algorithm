package com.ep.LeetCode;

import java.util.*;

/***
 * @author dep
 * @version 1.0
 */
public class exercise94_二叉树的中序遍历 {

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

      // 方法1： 递归
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            inorder(root,list);
            return list;
        }
        public void inorder(TreeNode root, List<Integer> list) {
          if (root == null) {
              return;
          }
          inorder(root.left,list);
          list.add(root.val);
          inorder(root.right,list);
        }

        // 方式2：迭代
        public List<Integer> inorderTraversal2(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            // Deque是一个双端队列
            // Deque<TreeNode> stk = new LinkedList<>();
            // 也可以换成栈
            Stack<TreeNode> stk = new Stack<>();
            while (root != null || !stk.isEmpty()) {
                // 左子树全部入栈
                while (root != null) {
                    stk.push(root);
                    root  = root.left;
                }
                root = stk.pop();
                list.add(root.val);
                // 最左下结点的右子树
                root = root.right;
            }
            return list;
        }


}
