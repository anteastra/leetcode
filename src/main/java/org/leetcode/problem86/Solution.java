package org.leetcode.problem86;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftPartitionHead = null;
        ListNode rightPartitionHead = null;
        ListNode leftCurrent = null;
        ListNode rightCurrent = null;

        ListNode current = head;
        while(current != null) {
            if (current.val < x) {
                if (leftPartitionHead == null) {
                    leftPartitionHead = new ListNode(current.val);
                    leftCurrent = leftPartitionHead;
                } else {
                    leftCurrent.next = new ListNode(current.val);
                    leftCurrent = leftCurrent.next;
                }
            } else {
                if (rightPartitionHead == null) {
                    rightPartitionHead = new ListNode(current.val);
                    rightCurrent = rightPartitionHead;
                } else {
                    rightCurrent.next = new ListNode(current.val);
                    rightCurrent = rightCurrent.next;
                }
            }
            current = current.next;
        }
        if (leftCurrent == null) {
            return rightPartitionHead;
        }
        leftCurrent.next = rightPartitionHead;
        return leftPartitionHead;
    }
}