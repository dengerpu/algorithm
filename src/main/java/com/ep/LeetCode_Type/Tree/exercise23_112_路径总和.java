package com.ep.LeetCode_Type.Tree;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-03 9:08
 */
public class exercise23_112_路径总和 {
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
//    static private boolean flag;
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null ) return false;
//        flag = false;
//        backTracking(root, targetSum,0);
//        return flag;
//    }
//    public void backTracking(TreeNode node, int targetSum, int sum) {
//        sum += node.val;
//        if (node.left == null && node.right == null) { // 如果是叶子结点
//            if (sum == targetSum) {
//               flag = true;
//            }
//            return ;
//        }
//        if (node.left != null) {
//            backTracking(node.left, targetSum, sum);
//            sum -= node.left.val;
//        }
//        if (node.right != null) {
//            backTracking(node.right, targetSum, sum);
//            sum -= node.right.val;
//        }
//    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null ) return false;
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    // 层序遍历
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueValue = new LinkedList<>();
        queueNode.add(root);
        queueValue.add(root.val);
        while (!queueNode.isEmpty()) {
            int size = queueNode.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queueNode.poll();
                Integer temp = queueValue.poll();
                if (node.left == null && node.right == null && temp == targetSum) {
                    return true;
                }
                if (node.left != null) {
                    queueNode.add(node.left);
                    queueValue.add(temp + node.left.val);
                }
                if (node.right != null) {
                    queueNode.add(node.right);
                    queueValue.add(temp + node.right.val);
                }
            }
        }
        return false;
    }
}
