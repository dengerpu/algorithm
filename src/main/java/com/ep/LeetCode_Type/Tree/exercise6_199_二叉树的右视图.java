package com.ep.LeetCode_Type.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-25 10:20
 */
public class exercise6_199_二叉树的右视图 {
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
    // 层次遍历，结果集中只加入每层最后一个元素
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) queue.add(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) { // 遍历完成之后node就是最右侧的元素
                node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(node.val);
        }
        return  res;
    }
}
