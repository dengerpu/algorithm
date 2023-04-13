package com.ep.LeetCode_Type.Tree;

import org.assertj.core.data.MapEntry;

import java.util.*;
import java.util.stream.Collectors;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-13 8:54
 */
public class exercise31_501_二叉搜索树中的众数 {
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

    // 借助额外的空间
    static HashMap<Integer, Integer> map;
    public int[] findMode1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) list.stream().mapToInt(Integer::intValue).toArray();
        map = new HashMap<>();
        inorder(root);
        // 对map进行排序
        List<Map.Entry<Integer, Integer>> mapEntryList = map.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .collect(Collectors.toList());
        list.add(mapEntryList.get(0).getKey());
        for (int i = 1; i < mapEntryList.size(); i++) {
            if (mapEntryList.get(i).getValue() == mapEntryList.get(i - 1).getValue()) {
                list.add(mapEntryList.get(i).getKey());
            } else {
                break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0 ) + 1);
        inorder(root.right);
    }

    static int count;
    static int maxCount;
    TreeNode pre;
    List<Integer> list;
    // 递归
    public int[] findMode2(TreeNode root) {
        count = 0;
        maxCount = 0;
        pre = null;
        list = new ArrayList<>();
        dfs(root);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public void dfs(TreeNode curr) {
        if (curr == null) return;
        dfs(curr.left); // 左
        // 中
        if (pre == null) { // 第一个节点
            count = 1;
        } else if (pre.val == curr.val){ // 和前一个结点值相同
            count ++;
        } else {
            count = 1;
        }
        pre = curr;
        if (count == maxCount) { // 如果和最大值相同，则收集结果
            list.add(curr.val);
        }
        if (count > maxCount) {
            maxCount = count; // 更新最大频率
            list.clear();
            list.add(curr.val);
        }
        dfs(curr.right);
    }

    // 迭代
    public int[] findMode(TreeNode root) {
        count = 0;
        maxCount = 0;
        pre = null;
        list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (pre == null) {
                    count = 1;
                } else if(pre.val == curr.val) {
                    count ++;
                } else {
                    count = 1;
                }
                pre = curr;
                if (count == maxCount) { // 如果和最大值相同，则收集结果
                    list.add(curr.val);
                }
                if (count > maxCount) {
                    maxCount = count; // 更新最大频率
                    list.clear();
                    list.add(curr.val);
                }
                curr = curr.right;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
