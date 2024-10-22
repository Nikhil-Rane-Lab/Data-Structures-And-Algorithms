package DSA.graph;

//https://leetcode.com/problems/surrounded-regions
public class L130SurroundedRegions {
// https://www.youtube.com/watch?v=BtdgAys4yMk

/*
    Approach:
    DFS from Boundary: First, the algorithm identifies all 'O' cells that are connected to the boundary of the board
    by starting DFS from each 'O' on the edges. These are temporarily marked as 'B' (boundary) to prevent them from
    being converted to 'X'.

    Conversion: After the DFS traversal, all the remaining 'O' cells, which are surrounded by 'X', are converted to 'X'.
    The 'B' cells (which represent 'O's connected to the boundary) are reverted back to 'O'.
*/

public void solve(char[][] board) {
        int rowCount = board.length;
        int colCount = board[0].length;

//      Step 1: Mark all 'O's connected to the boundary as 'B'
//      This loop iterates over the first and last columns of the board for each row
        for (int i = 0; i < rowCount; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][colCount - 1] == 'O') {
                dfs(board, i, colCount - 1);
            }
        }

//      This loop iterates over the first and last rows of the board for each column
        for (int j = 0; j < colCount; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rowCount - 1][j] == 'O') {
                dfs(board, rowCount - 1, j);
            }
        }

        // Step 2: Convert all remaining 'O' to 'X', and 'B' back to 'O'
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'B') {
                    board[i][j] = 'O';  // Revert unnecessary change
                }
            }
        }
    }

    private void dfs(char[][] board, int rowNum, int colNum) {
        if (rowNum < 0 || colNum < 0 || rowNum >= board.length || colNum >= board[0].length || board[rowNum][colNum] != 'O') {4
                // ⭐ board[rowNum][colNum] != 'O' as board[rowNum][colNum] can be 'X' or 'B' too
            return;
        }

        board[rowNum][colNum] = 'T';  // Mark as part of the non-surrounded region

        dfs(board, rowNum - 1, colNum);
        dfs(board, rowNum + 1, colNum);
        dfs(board, rowNum, colNum - 1);
        dfs(board, rowNum, colNum +1);
    }

//    Time Complexity: O(m * n) where m is the number of rows and n is the number of columns in the board.
//    Space Complexity: O(m * n) in the worst case due to the recursion stack.
}
