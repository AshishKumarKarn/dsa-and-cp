package karn.platforms.leetcode.potd.date09022026;

import karn.platforms.leetcode.potd.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        updateNodesDFS(nodes, root);
        Collections.sort(nodes);
        System.out.println(nodes);
        if (nodes.size() == 1) {
            return root;
        }
        TreeNode node = buildBST(nodes, 0, nodes.size() - 1);
        return node;
    }

    private TreeNode buildBST(List<Integer> nodes, int i, int j) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            TreeNode node = new TreeNode();
            node.val = nodes.get(i);
            return node;
        }
        int mid = (j + i) / 2;
        TreeNode node = new TreeNode();
        node.val = nodes.get(mid);
        node.left = buildBST(nodes, i, mid - 1);
        node.right = buildBST(nodes, mid + 1, j);
        return node;
    }

    private void updateNodesDFS(List<Integer> nodes, TreeNode node) {
        if (node == null) {
            return;
        }
        nodes.add(node.val);
        updateNodesDFS(nodes, node.left);
        updateNodesDFS(nodes, node.right);

    }
}