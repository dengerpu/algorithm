package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-01 11:04
 */
public class exercise572_另一棵树的子树 {
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root , subRoot);
    }
    public boolean dfs(TreeNode root, TreeNode subRoot) {
          if (root == null) {
              return false;
          }
          return check(root,subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }
    public boolean check(TreeNode root, TreeNode subRoot) {
          if (root == null && subRoot == null) {
              return true;
          }
          if (root== null || subRoot == null || root.val != subRoot.val) {
              return false;
          }
          return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }
}
