package com.ep.LeetCode_Type.Tree;

import sun.font.FontRunIterator;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-04 8:59
 */
public class exercise24_106_从中序与后序遍历序列构造二叉树 {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        // 1.后序数组为0，空节点
//        if(postorder.length == 0) return null;
//        // 2.后序数组最后一个元素为根节点
//        int rootValue = postorder[postorder.length - 1];
//        TreeNode root = new TreeNode(rootValue);
//        // 如果为叶子节点直接返回
//        if (postorder.length == 1) return root;
//        //3. 寻找中序数组位置切割点
//        int index = 0;
//        for (int i = 0; i < inorder.length; i++) {
//            if (inorder[i] == rootValue) {
//                index = i;
//                break;
//            }
//        }
//        // 4.：切割中序数组，得到 中序左数组和中序右数组
//        // 5.：切割后序数组，得到 后序左数组和后序右数组
//        // root.left = buildTree(中序左数组, 后序左数组);
//        // root.right = buildTree(中序右数组, 后序右数组);

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
            map.put(inorder[i],i);
        }
        return findNode(inorder,0,inorder.length,postorder,0,postorder.length);
    }
    public TreeNode findNode(int[] inorder, int inBegin,int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inBegin >= inEnd || postBegin >= postEnd) { // 左闭右开
            return null;
        }
        // 找到后序数组的最后一个元素在中序数组的位置
        int rootIndex = map.get(postorder[postEnd - 1]);
        // 构造根节点
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int lenOfLeft = rootIndex - inBegin;
        // 后序：左右中，中序：左中右
        // 在中序中找到中的位置，中序左边的长度，也就是后序数组左的长度
        root.left = findNode(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd, postorder, postBegin + lenOfLeft, postEnd - 1);
        return root;
    }
}
