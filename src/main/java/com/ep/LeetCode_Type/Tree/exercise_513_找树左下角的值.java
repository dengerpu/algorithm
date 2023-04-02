package com.ep.LeetCode_Type.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-02 10:16
 */
public class exercise_513_找树左下角的值 {
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
    public int findBottomLeftValue1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) result = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return result;
    }

    private int Deep = -1; // 树的深度
    private int value = 0;

    // 递归法
    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }
    private void findLeftValue(TreeNode root, int deep) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
        }
        if (root.left != null) findLeftValue(root.left, deep + 1);
        if (root.right != null) findLeftValue(root.right, deep + 1);
    }
}
