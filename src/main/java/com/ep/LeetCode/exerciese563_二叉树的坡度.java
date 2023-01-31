package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-31 10:11
 */
public class exerciese563_二叉树的坡度 {
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
      // 方法一： 深度优先搜索
    int ans = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sumLeft = dfs(node.left);
        int sumRight = dfs(node.right);
        ans += Math.abs(sumLeft-sumRight);
        return sumLeft + sumRight + node.val;
    }

}
