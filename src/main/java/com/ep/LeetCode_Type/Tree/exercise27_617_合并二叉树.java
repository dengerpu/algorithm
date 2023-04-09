package com.ep.LeetCode_Type.Tree;

import org.lanqiao.algo.elementary._06_math.Case10_第十万零二个素数;

import java.util.LinkedList;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-09 9:00
 */
public class exercise27_617_合并二叉树 {
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = new TreeNode();
        if (root1 != null && root2 != null) {
            root.val = root1.val + root2.val;
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
            return root;
        }else if (root1 != null && root2 == null) {
            root.val = root1.val;
            root.left = mergeTrees(root1.left, null);
            root.right = mergeTrees(root1.right, null);
            return root;
        }else if (root2 != null && root1 == null) {
            root.val = root2.val;
            root.left = mergeTrees(null, root2.left);
            root.right = mergeTrees(null, root2.right);
            return root;
        } else {
            return null;
        }
    }
    // 前中序合并都可以，这里用前序
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees2(root1.left, root2.left);
        root1.right = mergeTrees2(root1.right, root2.right);
        return root1;
    }
    // 迭代法
    public TreeNode mergeTrees3(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            // 此时两节点一定不为空，val相加
            node1.val += node2.val;

            // 如果两棵树左节点都不为空，加入队列
            if (node1.left != null && node2.left != null) {
                queue.add(node1.left);
                queue.add(node2.left);
            }
            // 如果两棵树右节点都不为空，加入队列
            if (node1.right != null && node2.right != null) {
                queue.add(node1.right);
                queue.add(node2.right);
            }
            // 当t1的左节点 为空， t2节点不为空，就赋值过去
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }
}
