package DSA.backtracking;

//https://leetcode.com/problems/word-search
public class L79WordSearch {
//https://www.youtube.com/watch?v=m9TrOL1ETxI

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]) {
            return false; // Out of bounds or not matching or already visited
        }

        visited[i][j] = true; // Mark as visited
        boolean isWordPresent = dfs(board, word, visited, i - 1, j, index + 1)
                || dfs(board, word, visited, i + 1, j, index + 1)
                || dfs(board, word, visited, i, j - 1, index + 1)
                || dfs(board, word, visited, i, j + 1, index + 1);

        visited[i][j] = false; // Unmark as visited
        return isWordPresent;
    }
}

//TC: Worst Case: O(m * n * 4 ^ L ), where m and n are the dimensions of the grid,
// and L is the length of the word. The worst-case scenario occurs when every cell is visited
// multiple times, and each DFS explores up to 4 directions.4

//SC: O (m * n) for visited matrix

