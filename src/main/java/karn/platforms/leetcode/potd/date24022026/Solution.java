package karn.platforms.leetcode.potd.date24022026;

import karn.platforms.leetcode.potd.common.TreeNode;

public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return value(root, 0);
    }

    private int value(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        int nval = val;
        nval <<= 1;
        nval |= node.val;
        if (node.left == null && node.right == null) {
            return nval;
        }
        return value(node.left, nval) + value(node.right, nval);
    }
}