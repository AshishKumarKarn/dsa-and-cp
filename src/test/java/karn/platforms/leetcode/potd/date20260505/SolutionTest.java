package karn.platforms.leetcode.potd.date20260505;

import karn.platforms.leetcode.potd.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void rotateRight() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = new Solution().rotateRight(head, 2);

        assertEquals(4, result.val);
        assertEquals(5, result.next.val);
        assertEquals(1, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(3, result.next.next.next.next.val);
    }
}