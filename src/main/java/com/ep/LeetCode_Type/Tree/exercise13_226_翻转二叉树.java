package com.ep.LeetCode_Type.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-27 9:07
 */
public class exercise13_226_翻转二叉树 {
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
    // 先序递归翻转 （根左右）
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // 后序遍历翻转 (左右根)
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;
        invertTree2(root.left);
        invertTree2(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
    // 中序遍历翻转（左根右）
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return root;
        invertTree3(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree3(root.left); //右边的已经交换到左边了，所以这个左边是原来的右边
        return root;
    }
    // 层序遍历翻转
    public TreeNode invertTree4(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }
}
