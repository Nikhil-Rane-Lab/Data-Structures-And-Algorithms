package DSA.matrix;

//https://leetcode.com/problems/game-of-life
public class L289GameOfLife {

    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        // Directions array for the 8 neighbors
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        // Step 1: Mark the board with transition states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighborsCount = countLiveNeighbors(board, i, j, directions);

                // Rule 1 or Rule 3: Alive cell dies (under-population or over-population)
                if (board[i][j] == 1 && (liveNeighborsCount < 2 || liveNeighborsCount > 3)) {
                    board[i][j] = 2;  // Mark as Alive -> Dead
                }

                // Rule 4: Dead cell becomes alive (reproduction)
                if (board[i][j] == 0 && liveNeighborsCount == 3) {
                    board[i][j] = 3;  // Mark as Dead -> Alive
                }
            }
        }

        // Step 2: Final update based on transition states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0; // Alive -> Dead
                } else if (board[i][j] == 3) {  // Dead -> Alive
                    board[i][j] = 1;
                }
            }
        }
    }

    // Helper function to count live neighbors
    private int countLiveNeighbors(int[][] board, int row, int col, int[][] directions) {

        int liveNeighborsCount = 0;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length) {
                if (board[newRow][newCol] == 1 || board[newRow][newCol] == 2) {
                    liveNeighborsCount++;
                }
            }
        }

        return liveNeighborsCount;
    }
}

// TC: O(m * n) The algorithm iterates through each cell once to count neighbors and once to apply transitions.
// Therefore, the time complexity is O(m * n), where m is the number of rows and n is the number of columns.

// SC: O(1) because the algorithm only uses a few extra variables and modifies the board in place.
