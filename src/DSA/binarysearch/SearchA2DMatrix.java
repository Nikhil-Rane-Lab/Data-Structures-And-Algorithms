package DSA.binarysearch;

//? https://leetcode.com/problems/search-a-2d-matrix
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int left = 0;
        int right = rowCount * colCount - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int middleElement = matrix[mid / colCount][mid % colCount]; //⭐ MEMORIZE. This treats the 2D array as a flattened 1D array and find arr[mid] from it

            if (middleElement == target) {
                return true;
            } else if (middleElement > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    //* TC: O(log(m*n))
    //* SC: O(1)

    /***
     * We are essentially performing a binary search on a virtual 1D array of size (rowCount * colCount)
     * Binary search has a time complexity of O(log k) where k is the number of elements in the array.
     * In this case, k is (rowCount * colCount)
     * so the time complexity is O(log(m * n)).
     */
}
