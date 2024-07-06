package DSA.matrix;

//Q) https://leetcode.com/problems/set-matrix-zeroes
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        boolean firstRowContainsZero = false;
        boolean firstColumnContainsZero = false;

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        //Step 1: we will set firstRowContainsZero = true to mark for later that all elements in the first row should be zeroed.
        for (int i = 0; i < colCount; i++) {
            if (matrix[0][i] == 0) {
                firstRowContainsZero = true;
                break;
            }
        }

        //Set 2: we will set firstColumnContainsZero = true to mark for later that all elements in the first column should be zeroed.
        for (int i = 0; i < rowCount; i++) {
            if (matrix[i][0] == 0) {
                firstColumnContainsZero = true;
                break;
            }
        }

        // Step 3: Use first row and first column as markers
        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 4: Zero out cells based on first row and first column marks
        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: Zero out first row and first column if necessary
        if (firstRowContainsZero) {
            for (int i = 0; i < colCount; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColumnContainsZero) {
            for (int i = 0; i < rowCount; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    //TC: O(rowCount * colCount)
    //SC: O(1)
}
