package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-27 8:45
 */
public class exercise530_二叉搜索树的最小绝对差 {
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
      int pre;
      int ans;
      public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
      }
      public void dfs(TreeNode root) {
          if (root == null) {
              return;
          }
          dfs(root.left);
          if (pre == -1) {
              pre = root.val;
          } else {
              ans = Math.min(ans, root.val - pre);
              pre = root.val;
          }
          dfs(root.right);
      }
}
