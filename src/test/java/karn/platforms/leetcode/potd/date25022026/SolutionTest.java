package karn.platforms.leetcode.potd.date25022026;

import karn.platforms.leetcode.potd.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    void sumRootToLeaf() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        Solution solution = new Solution();
        assertEquals(22, solution.sumRootToLeaf(root));
    }
}