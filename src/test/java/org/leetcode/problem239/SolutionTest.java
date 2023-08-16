package org.leetcode.problem239;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxSlidingWindow() {
        Solution solution = new Solution();
        int k = 0;

        k = 3;
        int array[] = {1,3,-1,-3,5,3,6,7};
        int arrayExpected[] = {3,3,5,5,6,7};
        assertArrayEquals(arrayExpected, solution.maxSlidingWindow(array, k));

        k = 1;
        int array2[] = {1};
        int arrayExpected2[] = {1};
        assertArrayEquals(arrayExpected2, solution.maxSlidingWindow(array2, k));

        k = 3;
        int array3[] = {1,3,1,2,0,5};
        int arrayExpected3[] = {3,3,2,5};
        assertArrayEquals(arrayExpected3, solution.maxSlidingWindow(array3, k));

        k = 4;
        int array4[] = {-7,-8,7,5,7,1,6,0};
        int arrayExpected4[] = {7,7,7,7,7};
        assertArrayEquals(arrayExpected4, solution.maxSlidingWindow(array4, k));
    }
}