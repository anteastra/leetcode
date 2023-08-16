package org.leetcode.problem86;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void partition() {
        Solution solution = new Solution();
        int x = 3;

        ListNode head = new ListNode(1,
                new ListNode(4,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(5,
                                                new ListNode(2))))));
        System.out.println(solution.partition(head, x));
    }
}