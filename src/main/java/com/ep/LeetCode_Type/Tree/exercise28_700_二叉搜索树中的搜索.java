package com.ep.LeetCode_Type.Tree;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-10 8:55
 */
public class exercise28_700_二叉搜索树中的搜索 {
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
    //   searchBST(root->left, val)，别忘了 递归函数还有返回值。
    //递归函数的返回值是什么? 是 左子树如果搜索到了val，要将该节点返回。
    // 如果不用一个变量将其接住，那么返回值不就没了。
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val) return root;
        TreeNode result = null;
        if(val > root.val) {
            result = searchBST(root.right, val);
        } else if (val < root.val) {
            result = searchBST(root.left, val);
        }
        return result;
    }

    // 迭代法
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) {
                return root;
            }
            root = val > root.val ? root.right : root.left;
        }
        return null;
    }
}
