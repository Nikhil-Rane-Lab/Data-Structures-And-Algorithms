package DSA.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GFGRottenOranges {

    public int orangesRotting(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOrangeCount = 0;

        // Step 1: Enqueue all rotten oranges and count fresh oranges
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                } else if (grid[i][j] == 1) {
                    freshOrangeCount++;
                }
            }
        }

        if (freshOrangeCount == 0) {
            return 0;
        }

        // Directions for the four possible moves (up, down, left, right)
        int[][] directionArr = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int time = 0;

        // Step 2: BFS to rot all reachable oranges
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int currX = curr[0];
            int currY = curr[1];
            int currTime = curr[2];
            time = Math.max(time, currTime);

            for (int[] currDirection : directionArr) {
                int newX = currX + currDirection[0];
                int newY = currY + currDirection[1];

                if (newX >= 0 && newX < rowCount
                        && newY >= 0 && newY < colCount
                        && grid[newX][newY] == 1) {
                    queue.add(new int[]{newX, newY, currTime + 1});
                    grid[newX][newY] = 2;
                    freshOrangeCount--;
                }
            }
        }

        return freshOrangeCount == 0 ? time : -1; // Check if there are any fresh oranges left
    }
    //TC: O(rowCount * colCount) as each cell is processed at most once.
    //SC: O(rowCount * colCount) because of the queue used to store the coordinates of the rotten oranges.
}
