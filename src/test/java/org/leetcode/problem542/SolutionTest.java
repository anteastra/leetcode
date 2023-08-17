package org.leetcode.problem542;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();

        int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] expected = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] result = solution.updateMatrix(matrix);

        assertArrayEquals(expected, result);
    }
}