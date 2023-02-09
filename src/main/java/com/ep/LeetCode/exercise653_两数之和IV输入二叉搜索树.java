package com.ep.LeetCode;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayDeque;
import java.util.HashSet;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-09 11:11
 */
public class exercise653_两数之和IV输入二叉搜索树 {
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
    HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left,k) || findTarget(root.right, k);
    }
    // 广度优选搜索
    public boolean findTarget2(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (! queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }
}
