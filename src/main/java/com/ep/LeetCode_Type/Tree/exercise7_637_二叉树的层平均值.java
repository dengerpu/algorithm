package com.ep.LeetCode_Type.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-25 10:36
 */
public class exercise7_637_二叉树的层平均值 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        List<Double> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            Double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(sum / size);
        }
        return res;
    }
}
