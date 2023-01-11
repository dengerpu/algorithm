package com.ep.LeetCode;

import java.util.ArrayList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-01-10 18:09
 */
public class exercise501_二叉搜索树中的众数 {
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
    int base, count, maxCount;
    List<Integer> answer = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            mode[i] = answer.get(i);
        }
        return mode;
    }
    // 二叉搜索树中序遍历是一个有序序列
    public void dfs(TreeNode o) {
          if (o == null) {
              return;
          }
          dfs(o.left);
          update(o.val);
          dfs(o.right);
    }
    public void update(int x) {
          if (x == base) {
              count++;
          } else {
              count = 1;
              base = x;
          }
          if (count == maxCount) {
              answer.add(base);
          }
          if (count > maxCount) {
              maxCount = count;
              answer.clear();;
              answer.add(base);
          }
    }
}
