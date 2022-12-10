package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-10 14:07
 */
public class exercise226_翻转二叉树 {
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
      // 方法一 递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        dfs(root);
        return root;
    }
    private void dfs(TreeNode root) {
          if (root == null) {
              return;
          }
          TreeNode temp = root.left;
          root.left = root.right;
          root.right = temp;
          dfs(root.left);
          dfs(root.right);
    }
}
