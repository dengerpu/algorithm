package com.ep.LeetCode_Type.Tree;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-20 9:18
 */
public class exercise37_108_将有序数组转换为二叉搜索树 {
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
    public TreeNode sortedArrayToBST(int[] nums) {
       if (nums.length == 0) return null;
       return  buildBST(nums, 0, nums.length - 1);
    }
    // 左闭右闭区间
    public TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + end >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1 , end);
        return root;
    }

    // 迭代法
    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums.length == 0) return null;
        Queue<Integer> leftQueue = new LinkedList<>(); // 存放左区间
        Queue<Integer> rightQueue = new LinkedList<>(); // 存放右区间
        Queue<TreeNode> nodeQueue = new LinkedList<>(); // 存放结点
        TreeNode root = new TreeNode(0);
        nodeQueue.add(root);
        leftQueue.add(0);
        rightQueue.add(nums.length - 1);
        while (!nodeQueue.isEmpty()) {
            int left = leftQueue.poll();
            int right = rightQueue.poll();
            TreeNode node = nodeQueue.poll();

            int mid = left + (right - left) / 2;
            node.val = nums[mid];
            if (left <= mid - 1) {
                node.left = new TreeNode(0);
                nodeQueue.add(node.left);
                leftQueue.add(left);
                rightQueue.add(mid - 1);
            }
            if (right >= mid + 1) {
                node.right = new TreeNode(0);
                nodeQueue.add(node.right);
                leftQueue.add(mid + 1);
                rightQueue.add(right);
            }
        }
        return root;
    }
}
