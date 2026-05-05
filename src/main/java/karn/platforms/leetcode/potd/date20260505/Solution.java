package karn.platforms.leetcode.potd.date20260505;

import karn.platforms.leetcode.potd.common.ListNode;
//https://leetcode.com/problems/rotate-list/?envType=daily-question&envId=2026-05-05
//lc 61. Rotate List
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode node = head;
        if (node == null || k == 0) {
            return head;
        }
        int length = length(head);
        k %= length;
        while (k > 0) {
            node = rotateOne(node, length);
            k--;
        }
        return node;

    }

    private ListNode rotateOne(ListNode head, int length) {
        int cursor = 0;
        ListNode secondLastnode = head;
        while (cursor < length - 2) {
            cursor++;
            secondLastnode = secondLastnode.next;
        }
        ListNode lastNode = secondLastnode.next;
        secondLastnode.next = null;
        lastNode.next = head;
        return lastNode;
    }

    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}