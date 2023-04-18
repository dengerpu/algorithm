package com.ep.LeetCode_Type.Tree;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-17 9:04
 */
public class exercise35_450_删除二叉搜索树中的节点 {
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

    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) return null;
        root = delete(root, key);
        return root;
    }
    // 1.删除的节点是左叶子结点
    // 2.删除的节点是右叶子结点
    // 3.删除的节点是根节点
    // 4.删除的节点是左节点
    // 5.删除的节点是右结点
    public TreeNode delete(TreeNode curr, int key) {
        if (curr == null) return curr;
        if (curr.val > key) {
            curr.left = delete(curr.left, key);
        }else if (curr.val < key) {
            curr.right = delete(curr.right, key);
        } else {
            if (curr.left == null) return curr.right;
            if (curr.right == null) return curr.left;
            TreeNode temp = curr.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            curr.val = temp.val;
            curr.right = delete(curr.right, temp.val);
        }
        return curr;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root; // 第一种情况，没找到删除的节点，遍历到空节点值
        if (root.val == key) {
            // 第二种情况: 左右孩子都为空（叶子结点），直接删除结点
            if (root.left == null && root.right == null) {
                return null;
            }
            // 第三种情况：左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
            else if (root.left == null) {
                return root.right;
            }
            // 第四种情况：其右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
            else if (root.right == null) {
                return root.left;
            }
            // 第五种情况：左右孩子节点都不为空，则将删除节点的左子树放到删除节点的右子树的最左面节点的左孩子的位置
            // 并返回删除节点右孩子为新的根节点。
            else {
                TreeNode cur = root.right; // 找右子树最左面的节点
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left; // 把要删除的节点（root）左子树放在cur的左子树的位置
                root = root.right; // 返回旧root作为新root
                return root;
            }
        }
        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;
    }

    // 迭代
    // 1.删除的节点是左叶子结点
    // 2.删除的节点是右叶子结点
    // 3.删除的节点是根节点
    // 4.删除的节点是左节点
    // 5.删除的节点是右结点
    // 将目标节点（删除节点）的左子树放到 目标节点的右子树的最左面节点的左孩子位置上
    // 并返回目标节点右孩子为新的根节点
    public TreeNode deleteOneNode(TreeNode target) {
        if (target == null) return target;
        // 右子树为空，就返回左结点。（也包含了左子树为空，返回空）直接pre指向 target.left （实现了删除target）
        if (target.right == null) return target.left;
        // 找到右子树最左结点
        TreeNode curr = target.right;
        while (curr.left != null) {
            curr = curr.left;
        }
        curr.left = target.left;
        return target.right;
    }
    public TreeNode deleteNode2(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode pre = null;
        while (curr != null) {
            if (curr.val == key) break;
            pre = curr;
            if (curr.val < key) curr = curr.right;
            else curr = curr.left;
        }
        if (pre == null) { // 要删除的节点是根节点
            return deleteOneNode(curr);
        }
        if (pre.val < key) { // 删除的是右节点
            pre.right = deleteOneNode(curr);
        } else {
            pre.left = deleteOneNode(curr);
        }
        return root;
    }
}
