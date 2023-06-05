package com.ep.LeetCode_Type.DynamicProgramming;

/***
 * @author dep
 * @version 1.0
 * @date 2023-06-05 9:42
 */
public class exercise21_337_打家劫舍III {
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
    public int rob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }
    public int[] robAction(TreeNode root) {
        // 下标为0记录不偷该节点所得到的的最大金钱，下标为1记录偷该节点所得到的的最大金钱。
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        // 偷左右孩子 (左孩子偷和不偷的最大值 + 右孩子偷和不偷的最大值)
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷根节点，左右孩子都不偷
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
