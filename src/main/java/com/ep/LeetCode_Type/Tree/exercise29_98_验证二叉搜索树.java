package com.ep.LeetCode_Type.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-11 8:50
 */
public class exercise29_98_验证二叉搜索树 {
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
    // 错误写法，可能会存在每个小的二叉树是二叉搜索树（不能保证根节点比左边的都大，比右边的都小）
//    public boolean isValidBST(TreeNode root) {
//        if (root == null || (root.left == null && root.right == null)) return true;
//        if (root.left != null && root.left.val >= root.val) {
//            return false;
//        }
//        if (root.right != null && root.right.val <= root.val) {
//            return false;
//        }
//        return isValidBST(root.left) && isValidBST(root.right);
//    }

//    static List<Integer> res = new LinkedList<>();
//    // 中序遍历，二叉搜索树中序遍历可以得到一个有序序列
//    public void inorder(TreeNode root) {
//        if (root == null) return;
//        inorder(root.left);
//        res.add(root.val);
//        inorder(root.right);
//    }
//    public boolean isValidBST(TreeNode root) {
//        res.clear();
//        inorder(root);
//        for (int i = 1; i < res.size(); i++) {
//            if (res.get(i-1) >= res.get(i)) return false;
//        }
//        return true;
//    }
    // 递归

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        if (node.val <= lower || node.val >= upper) return false;
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    // 迭代
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于前一个inorder,说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
