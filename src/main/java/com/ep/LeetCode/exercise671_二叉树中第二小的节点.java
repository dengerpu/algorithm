package com.ep.LeetCode;

import java.util.Arrays;
import java.util.HashSet;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-10 11:17
 */
public class exercise671_二叉树中第二小的节点 {
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
    int ans;int rootValue;
    // 二叉树根节点的值即为所有节点中的最小值。
    public int findSecondMinimumValue(TreeNode root) {
        ans = -1;
        rootValue = root.val;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode node) {
         if (node == null) {
             return;
         }
         if (ans != -1 && node.val >= ans) {
             return;
         }
         if (node.val > rootValue) {
             ans = node.val;
         }
         dfs(node.left);
         dfs(node.right);
    }
}
