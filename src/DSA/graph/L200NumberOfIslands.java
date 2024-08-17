package DSA.graph;

//https://leetcode.com/problems/number-of-islands
public class L200NumberOfIslands {

    public int numIslands(char[][] grid) {
        int islandsCount = 0;
        int rowsCount = grid.length;
        int colsCount = grid[0].length;

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colsCount; j++) {
                if (grid[i][j] == '1') {
                    islandsCount++;
                    dfs(grid, i, j);
                }
            }
        }

        return islandsCount;
    }

    private void dfs(char[][] grid, int rowNum, int colNum) {

        if (rowNum < 0 || colNum < 0 || rowNum >= grid.length || colNum >= grid[0].length || grid[rowNum][colNum] == '0') {
            return;
        }

        grid[rowNum][colNum] = '0'; // Mark the land as visited by sinking the island

        // Visit all adjacent cells (up, down, left, right) ⭐ Order does not matter
        dfs(grid, rowNum - 1, colNum); //up
        dfs(grid, rowNum + 1, colNum); //down
        dfs(grid, rowNum, colNum - 1); //left
        dfs(grid, rowNum, colNum + 1); //right
        //⭐ If diagonal traversal is also allowed, then we simply need to add the following 4 lines of code
//        dfs(grid, i - 1, j - 1); // Up-Left
//        dfs(grid, i - 1, j + 1); // Up-Right
//        dfs(grid, i + 1, j - 1); // Down-Left
//        dfs(grid, i + 1, j + 1); // Down-Right
    }
}

//TC: O(m * n), where m is the number of rows and n is the number of columns in the grid. This is because each cell is visited once.
//SC: O(m * n) in the worst case, due to the recursion stack when every cell is part of an island.