package com.ep.LeetCode_Type.Tree;

import java.util.*;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-26 9:38
 */
public class exercise8_429_N叉树的层序遍历 {
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null){
                    list.add(node.val);
                    for (Node temp : node.children) {
                        if (temp != null) queue.add(temp);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
