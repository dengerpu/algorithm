package com.ep.LeetCode;

import org.omg.CORBA.INTERNAL;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2022-11-28 10:41
 */
public class exercise144_二叉树的前序遍历 {
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    public void preorder(TreeNode root, List list) {
         if (root == null) {
             return;
         }
         list.add(root.val);
         preorder(root.left,list);
         preorder(root.right,list);
    }

    // 方法二 迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null ) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while(node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    // 方法三
//    public List<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<Integer>;
//        if (root == null) {
//            return list;
//        }
//
//        TreeNode p1 = root, p2 = null;
//
//        while (p1 != null) {
//            p2 = p1.left;
//            if(p2 != null) {
//
//            }
//        }
//    }
}
