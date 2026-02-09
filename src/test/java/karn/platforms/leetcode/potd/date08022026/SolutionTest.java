package karn.platforms.leetcode.potd.date08022026;

import karn.platforms.leetcode.potd.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class SolutionTest {

    @Test
    void isBalanced() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode();
        root.val = 3;
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        assertTrue(solution.isBalanced(root));
    }
}