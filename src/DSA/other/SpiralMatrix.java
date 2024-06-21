package DSA.other;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        List<Integer> resultList = new ArrayList<>();

        while (left <= right && top <= bottom) { //(A)
            for (int i = left; i <= right; i++) {
                resultList.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                resultList.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) { //(I)
                for (int i = right; i >= left; i--) {
                    resultList.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) { //(II)
                for (int i = bottom; i >= top; i--) {
                    resultList.add(matrix[i][left]);
                }
                left++;
            }
        }

        return resultList;
    }

    /*TODO
        (I) and (II) these are the same conditions as in (A)


     TODO
        TC: O(m * n) where "m" is the number of rows and "n" is the number of columns in the matrix. This is because we visit each element of the matrix exactly once.
        SC: O (m * n) + O (1) [resultList + additional constant variables
        ]

     */
}
