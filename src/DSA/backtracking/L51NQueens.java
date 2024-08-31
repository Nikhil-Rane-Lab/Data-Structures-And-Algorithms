package DSA.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens
public class L51NQueens {
//https://www.youtube.com/watch?v=i05Ju7AftcM

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> solutions = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, board, solutions);

        return solutions;
    }

    private void solve(int row, char[][] board, List<List<String>> solutions) {
        if (row == board.length) {
            solutions.add(construct(board));
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

    private List<String> construct(char[][] board) {
        List<String> resultList = new ArrayList<>();
        for (char[] chars : board) {
            resultList.add(String.valueOf(chars));
        }

        return resultList;
    }

    //TC: O(N!) because we are placing N queens on an N x N board,
    // and for each queen, we try N possibilities, leading to factorial time complexity.

    //SC: The space complexity is O(N^2) for the board, plus O(N) for the recursion stack, giving a total of O(N^2).
}
