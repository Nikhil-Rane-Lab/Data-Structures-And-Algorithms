package DSA.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens-ii
public class L52NQueens2 {
//https://www.youtube.com/watch?v=i05Ju7AftcM

    int count = 0;

    public int totalNQueens(int n) {

        List<List<String>> solutions = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, board, solutions);

        return count;
    }

    private void solve(int row, char[][] board, List<List<String>> solutions) {
        if (row == board.length) {
            count++;
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(row + 1, board, solutions);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    //TC: O(N!) because we are placing N queens on an N x N board,
    // and for each queen, we try N possibilities, leading to factorial time complexity.

    //SC: The space complexity is O(N^2) for the board, plus O(N) for the recursion stack, giving a total of O(N^2).

}

//2nd approach
class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n]; // columns   |
        boolean[] d1 = new boolean[2 * n]; // diagonals \
        boolean[] d2 = new boolean[2 * n]; // diagonals /
        backtrack(0, cols, d1, d2, n);
        return count;
    }

    private void backtrack(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if (cols[col] || d1[id1] || d2[id2]) continue;

            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;

            backtrack(row + 1, cols, d1, d2, n);

            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }
}

//TC: O(n!)
//SC: O(n)

