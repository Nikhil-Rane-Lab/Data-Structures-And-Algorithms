package DSA.binarysearch.other;

//https://leetcode.com/problems/sqrtx
public class L69SquareRoot {

    public int mySqrt(int x) {
        if (x < 2) {
            return x; // 0 and 1 are their own square roots
        }

        int left = 1; //⭐
        int right = x / 2;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long square = (long) mid * mid; // Use long to prevent overflow during multiplication

            if (square == x) {
                return mid;
            } else if (square < x) {
                result = mid; // Update result and search right
                left = mid + 1;
            } else {
                right = mid - 1; // Search left
            }
        }

        return result;
    }
}
//TC: O(log x)
//SC: O(1)
