package com.ep.LeetCode_Type.Tree;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-17 9:04
 */
public class exercise35_450_删除二叉搜索树中的节点 {
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        root = delete(root, key);
        return root;
    }
    // 1.删除的节点是左叶子结点
    // 2.删除的节点是右叶子结点
    // 3.删除的节点是根节点
    // 4.删除的节点是左节点
    // 5.删除的节点是右结点
    public TreeNode delete(TreeNode curr, int key) {
        if (curr == null) return curr;
        if (curr.val > key) {
            curr.left = delete(curr.left, key);
        }else if (curr.val < key) {
            curr.right = delete(curr.right, key);
        } else {
            if (curr.left == null) return curr.right;
            if (curr.right == null) return curr.left;
            TreeNode temp = curr.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            curr.val = temp.val;
            curr.right = delete(curr.right, temp.val);
        }
        return curr;
    }
}
