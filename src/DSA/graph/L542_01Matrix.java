package DSA.graph;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/01-matrix/description/
public class L542_01Matrix {
//https://www.youtube.com/watch?v=edXdVwkYHF8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=15

    public int[][] updateMatrix(int[][] mat) {
        int rowCount = mat.length;
        int colCount = mat[0].length;
        int[][] distArr = new int[rowCount][colCount];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the distance matrix and enqueue all 0s
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (mat[i][j] == 0) {
                    distArr[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    distArr[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Directions for moving up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        //BFS traversal
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >= 0 && newX < rowCount && newY >= 0 && newY < colCount) {
                    if (distArr[newX][newY] > distArr[x][y] + 1) {
                        distArr[newX][newY] = distArr[x][y] + 1;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }

        return distArr;
    }
}

//TC: O(rowCount * colCount) as each cell is processed exactly once.
//SC: O(rowCount * colCount) for BFS queue and distance matrix
