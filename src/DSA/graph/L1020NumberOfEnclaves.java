package DSA.graph;

//https://leetcode.com/problems/number-of-enclaves/
public class L1020NumberOfEnclaves {
//https://www.youtube.com/watch?v=rxKcepXQgU4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=15

    public int numEnclaves(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;

        // DFS to eliminate boundary-connected land cells
        // We are basically converting all land cells connected to boundary and cells connected to such cells as sea
        // as they are not part of our final answer
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (i == 0 || i == rowCount - 1 || j == 0 || j == colCount - 1) {
                    if (grid[i][j] == 1) {
                        dfs(grid, i, j);
                    }
                }
            }
        }

        // Count remaining land cells
        int count = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length
                || grid[i][j] == 0) {
            return;
        }

        //mark the cell as sea
        grid[i][j] = 0;

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

//TC: O(rowCount * colCount) as each cell is processed exactly once.
//SC: O(rowCount * colCount) due to recursion stack.
