package com.ep.LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-02-03 11:20
 */
public class exercise590_N叉树的后序遍历 {
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
    // 方法一：递归
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    public void dfs(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            dfs(node,list);
        }
        list.add(root.val);
    }
    // 方法二：迭代
    public List<Integer> postorder2(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        HashSet<Node> visited = new HashSet<>();
        stack.push(root);
        while (! stack.isEmpty()) {
            // 取出栈顶元素
            Node node = stack.peek();
            /**如果当前节点为叶子结点或者当前节点的子节点已经遍历过*/
            if (node.children.size() == 0 || visited.contains(node)) {
                stack.pop();
                list.add(node.val);
                continue;
            }
            for (int i = node.children.size() - 1; i >= 0 ; i--) {
                stack.push(node.children.get(i));
            }
            visited.add(node);
        }
        return list;
    }
}
