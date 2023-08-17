package org.leetcode.problem542;

import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int xWidth = mat.length;
        int yWidth = mat[0].length;
        int[][] result = new int[xWidth][yWidth];

        Set<Point> pointSet = new HashSet<>();

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                Point point = new Point(i,j);
                result[i][j] = -1;
                pointSet.add(point);
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    pointSet.remove(point);
                }
            }
        }

        int closeValue = 0;
        while (!pointSet.isEmpty()) {
            List<Point> iterate = new ArrayList<>();
            iterate.addAll(pointSet);
            for (Point point : iterate) {
                if (checkClosePoints(point, result, closeValue)) {
                    result[point.x][point.y] = closeValue + 1;
                    pointSet.remove(point);
                }
            }
            closeValue++;
        }

        return result;
    }

    private boolean checkClosePoints(Point point, int[][] mat, int value) {
        int xWidth = mat.length;
        int yWidth = mat[0].length;

        if (point.x>0 && mat[point.x-1][point.y] == value) {
            return true;
        }
        if (point.x<(xWidth-1) && mat[point.x+1][point.y] == value) {
            return true;
        }

        if (point.y>0 && mat[point.x][point.y-1] == value) {
            return true;
        }
        if (point.y<(yWidth-1) && mat[point.x][point.y+1] == value) {
            return true;
        }

        return false;
    }

    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] expected = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] result = solution.updateMatrix(matrix);
        System.out.println(Arrays.deepToString(result));
    }
}
