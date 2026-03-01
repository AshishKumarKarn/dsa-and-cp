package karn.platforms.leetcode.potd.date20260208;

import karn.platforms.leetcode.potd.common.TreeNode;

//https://leetcode.com/problems/balanced-binary-tree/?envType=daily-question&envId=2026-02-09
public class Solution {

    private boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        balanced = true;
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        height(root);
        return this.balanced;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lt = height(node.left);
        int rt = height(node.right);
        if (Math.abs(lt - rt) > 1) {
            balanced = false;
            return 0;
        }
        return 1 + Math.max(lt, rt);

    }
}
