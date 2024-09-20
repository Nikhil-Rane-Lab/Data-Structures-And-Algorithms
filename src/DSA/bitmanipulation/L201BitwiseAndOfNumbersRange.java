package DSA.bitmanipulation;

//https://leetcode.com/problems/bitwise-and-of-numbers-range
public class L201BitwiseAndOfNumbersRange {

    public int rangeBitwiseAnd(int left, int right) {

        int shift = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        return left <<= shift; //⭐ right <<= shift will also work here
    }
}

// TC : O(1) O(1), because the number of iterations is bounded by the number of bits (31).
// Each time we right-shift the numbers, we reduce the size of the numbers by 1 bit.
// The maximum number of shifts is equal to the number of bits in the numbers, which is at most 31 (since right <= 2^{31} - 1).

// SC: O(1)