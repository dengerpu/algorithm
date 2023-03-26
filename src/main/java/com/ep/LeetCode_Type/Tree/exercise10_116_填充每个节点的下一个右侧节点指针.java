package com.ep.LeetCode_Type.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/***
 * @author dep
 * @version 1.0
 * @date 2023-03-26 10:13
 */
public class exercise10_116_填充每个节点的下一个右侧节点指针 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new ArrayDeque<>();
        Node node = root;
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (i != size - 1) {
                    Node next = queue.peek();
                    curr.next = next;
                } else {
                    curr.next = null;  // 这里可以不加，默认就是NULL
                }
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        return node;
    }
}
