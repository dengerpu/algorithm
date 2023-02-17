package com.ep.LeetCode;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-17 9:54
 */
public class exercise700_二叉搜索树中的搜索 {
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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }else if (root.val < val) {
            return searchBST(root.right,val);
        }else{
            return searchBST(root.left, val);
        }
    }
    // 方法二： 迭代
    public TreeNode searchBST2(TreeNode root,int val) {
          while (root != null) {
              if (val == root.val) {
                  return root;
              }
              root = val < root.val ? root.left: root.right;
          }
          return null;
    }
}
