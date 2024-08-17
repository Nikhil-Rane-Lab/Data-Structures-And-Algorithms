package DSA.graph;

import java.sql.Time;

//https://leetcode.com/problems/surrounded-regions
public class L130SurroundedRegions {

    public void solve(char[][] board) {
        int rowCount = board.length;
        int colCount = board[0].length;

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

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';  // Revert unnecessary change
                }
            }
        }
    }

    private void dfs(char[][] board, int rowNum, int colNum) {
        if (rowNum < 0 || colNum < 0 || rowNum >= board.length || colNum >= board[0].length || board[rowNum][colNum] != 'O') {
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
