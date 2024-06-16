package DSA;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        boolean[][] rowsArr = new boolean[9][9];
        boolean[][] colsArr = new boolean[9][9];
        boolean[][] subBoxesArr = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = Character.getNumericValue(board[i][j]) - 1; //(num-1) is done for 0 based indexing
                    int subBoxIndex = (i / 3) * 3 + j / 3; //you will have to memorize this formula!

                    if (rowsArr[i][num] || colsArr[j][num] || subBoxesArr[subBoxIndex][num]) {
                        return false;
                    }

                    rowsArr[i][num] = true;
                    colsArr[j][num] = true;
                    subBoxesArr[subBoxIndex][num] = true;
                }
            }
        }

        return true;
    }

    /* TODO
        TC: O(1)
        SC: O(1)
        because size of board is fixed
     */
}
