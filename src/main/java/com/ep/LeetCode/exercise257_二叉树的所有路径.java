package com.ep.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2022-12-15 11:26
 */
public class exercise257_二叉树的所有路径 {
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
   // 方法一：深度优先搜索
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }
    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer stringBuffer = new StringBuffer(path);
            stringBuffer.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) { // 当前节点是叶子节点
                paths.add(stringBuffer.toString()); // 把路径加入到答案中
            } else {
                stringBuffer.append("->");  // 当前节点不是叶子结点，继续递归遍历
                constructPaths(root.left, stringBuffer.toString(), paths);
                constructPaths(root.right, stringBuffer.toString(), paths);
            }
        }
    }

    // 方法二： 广度优先搜索
    public List<String> binaryTreePaths2(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<String> pathQueue = new LinkedList<>();

        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();
            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
                }
                if (root.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                }
            }
        }
        return paths;
    }
}

