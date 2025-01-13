package DSA.graph.other;

import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
public class GFGNumberOfDistinctIslands {
//https://www.youtube.com/watch?v=7zmgQSJghpo

    int countDistinctIslands(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        boolean[][] visited = new boolean[rowCount][colCount];
        Set<Set<String>> uniqueIslandShapeSet = new HashSet<>();

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    Set<String> islandShape = new HashSet<>();
                    dfs(grid, visited, i, j, i, j, islandShape);
                    uniqueIslandShapeSet.add(islandShape);
                }
            }
        }

        return uniqueIslandShapeSet.size();
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j, int baseRow, int baseCol, Set<String> islandShape) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length
                || visited[i][j]
                || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = true; // 💡 instead of using visited array you could also sink the island by grid[i][j] = 0 to mark it as visited
        String relativePositionToBase = (i - baseRow) + "_" + (j - baseCol);
        islandShape.add(relativePositionToBase);

        dfs(grid, visited, i - 1, j, baseRow, baseCol, islandShape); //up
        dfs(grid, visited, i + 1, j, baseRow, baseCol, islandShape); //down
        dfs(grid, visited, i, j - 1, baseRow, baseCol, islandShape); //left
        dfs(grid, visited, i, j + 1, baseRow, baseCol, islandShape); //right
    }
}

//TC: O(M*N) as each cell is visited only once
//SC: O(M*N) for the size of visited array and the set storing island shapes
