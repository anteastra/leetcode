package org.leetcode.problem239;

import java.util.ArrayDeque;

// https://leetcode.com/problems/sliding-window-maximum/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return fastSolution(nums,k);
    }

    private int[] fastSolution(int[] nums, int k) {
        int[] resultArray = new int[nums.length - k + 1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (dq.peek() != null && dq.getFirst()<=(i-k)) {
                dq.pop();
            }
            if (dq.peek() == null) {
                dq.push(i);
            } else if (nums[dq.peek()] <= nums[i]) {
                dq.clear();
                dq.push(i);
            } else {
                while(nums[dq.getLast()] <= nums[i]) {
                    dq.removeLast();
                }
                dq.add(i);
            }

            if (i>=(k-1)) {
                resultArray[i-k+1] = nums[dq.getFirst()];
            }
        }
        return resultArray;
    }


    private int[] slowSolution(int[] nums, int k) {
        int[] resultArray = new int[nums.length - k + 1];

        // we will find first window result
        int firstValue = max(nums, k, 0);

        for (int i = 0; i < resultArray.length; i ++) {
            resultArray[i] = max(nums, k, i);
        }

        return resultArray;
    }

    private int max(int[] nums, int k, int shift) {
        int maxValue = nums[shift];
        for (int i=0; i < k; i++) {
            if (maxValue < nums[shift + i]) {
               maxValue = nums[shift + i];
            }
        }
        return maxValue;
    }
}