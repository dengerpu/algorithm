package com.ep.LeetCode_Type.Tree;

import java.util.*;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-25 9:49
 */
public class exercise4_102_二叉树的层序遍历 {
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
    // 层次遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue =  new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
