package DSA.matrix;

//https://leetcode.com/problems/rotate-image
public class RotateImage {


//    Steps:
//    I) Transpose the matrix: Convert rows into columns.
//    II) Reverse each row: This will give you the final rotated matrix.
    public void rotate(int[][] matrix) {

        // Step I: Transpose the matrix
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) { //j is initialized to i NOT 0
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step II: Reverse each row
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - j - 1]; //[length - j - 1] Swap the elements in each row from the "beginning to the middle" with the elements from the "end to the middle"
                matrix[i][length - j - 1] = temp; //just as in step I) the RHS of above line now becomes the LHS of this line
            }
        }
    }

//    TC: O(N^2)
//    SC: O(1)
}
