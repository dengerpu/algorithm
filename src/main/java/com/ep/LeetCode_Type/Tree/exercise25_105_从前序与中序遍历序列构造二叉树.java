package com.ep.LeetCode_Type.Tree;

import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-05 9:21
 */
public class exercise25_105_从前序与中序遍历序列构造二叉树 {
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
    static HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder,0,preorder.length,inorder,0,inorder.length);
    }
    public TreeNode build(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin >= preEnd || inBegin >= inEnd) { // 左闭右开
            return null;
        }
        // 在前序数组中找到根结点
        int rootValue = preorder[preBegin];
        // 找到根节点在中序数组中的索引位置
        int rootIndex = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        int lenOfLeft = rootIndex - inBegin;
        root.left = build(preorder,preBegin + 1, preBegin + 1 + lenOfLeft, inorder,inBegin, rootIndex);
        root.right = build(preorder, preBegin + 1 + lenOfLeft , preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }
}
