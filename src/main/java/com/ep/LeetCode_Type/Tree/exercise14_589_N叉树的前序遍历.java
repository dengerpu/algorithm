package com.ep.LeetCode_Type.Tree;

import java.util.ArrayList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-28 9:42
 */
public class exercise14_589_N叉树的前序遍历 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }
    public void dfs(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (Node node : root.children) {
            dfs(node, res);
        }
    }
}
