package com.ep.LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-07 11:15
 */
public class exercise637_二叉树的层平均值 {
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
    public List<Double> averageOfLevels(TreeNode root) {
          if (root == null) {
              return null;
          }
          List<Double> doubles = new ArrayList<>();
          Queue<TreeNode> queue = new ArrayDeque<>();
          queue.offer(root);
          while ( ! queue.isEmpty()) {
              Double sum = 0.0;
              int size = queue.size();
              for (int i = 0; i < size; i++) {
                  TreeNode node = queue.poll();
                  sum += node.val;
                  TreeNode left = node.left, right = node.right;
                  if (left != null) {
                      queue.offer(left);
                  }
                  if (right !=  null) {
                      queue.offer(right);
                  }
              }
              doubles.add(sum / size );
          }
        return doubles;
    }
}
