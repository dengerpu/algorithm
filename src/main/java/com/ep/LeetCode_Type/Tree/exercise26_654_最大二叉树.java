package com.ep.LeetCode_Type.Tree;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-06 9:08
 */
public class exercise26_654_最大二叉树 {
    public static class TreeNode {
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
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = build(nums, 0, nums.length);
        return root;
    }
    public static TreeNode build(int[] nums, int begin, int end) {
        if (begin >= end) {
            return null;
        }
        // 找到根节点的索引（ 最大值）
        Integer max = Integer.MIN_VALUE;
        Integer rootIndex = -1;
        for (int i = begin; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                rootIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums, begin, rootIndex);
        root.right = build(nums, rootIndex + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode treeNode = constructMaximumBinaryTree(nums);
        preTree(treeNode);
    }
    public static void preTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preTree(root.left);
        preTree(root.right);
    }
}
