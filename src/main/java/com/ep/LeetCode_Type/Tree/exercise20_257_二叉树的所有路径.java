package com.ep.LeetCode_Type.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-01 9:41
 */
public class exercise20_257_二叉树的所有路径 {
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
    static List<Integer> path;
    static List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        path = new ArrayList<>();
        res = new LinkedList<>();
        dfs(root);
        return res;
    }
    public void dfs(TreeNode node){
        path.add(node.val); // 中，中为什么写在这里，因为最后一个节点也要加入到path中
        if (node.left == null && node.right == null) { // 叶子结点
            if (path.size() > 0) {
                String str = "";
                for (int i = 0; i < path.size() - 1; i++) {
                    str += path.get(i) + "->";
                }
                str += path.get(path.size() - 1);
                res.add(str);
            }
            return;
        }
        if (node.left != null) { // 左
            dfs(node.left);
            path.remove(path.size() - 1); // 回溯
        }
        if (node.right != null) { // 右
            dfs(node.right);
            path.remove(path.size() - 1); // 回溯
        }
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new LinkedList<>();
        traversal(root,"",res);
        return res;
    }
    public void traversal(TreeNode node, String path, List<String> res) {
        path += node.val;
        if (node.left == null && node.right == null) {
            res.add(path);
            return;
        }
        if (node.left != null) {
            traversal(node.left, path + "->", res); // 回溯隐藏在这里
        }
        if (node.right != null) {
            traversal(node.right, path + "->", res); // 回溯隐藏在这里
        }
//        if (node != null) { // 伪代码，
//            path += "->";
//            traversal(node.left, path, res);
//            path.pop('>'); // 回溯过程
//            path.pop('-')
//        }
    }
}
