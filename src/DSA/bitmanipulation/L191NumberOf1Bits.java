package DSA.bitmanipulation;

//https://leetcode.com/problems/number-of-1-bits
public class L191NumberOf1Bits {

    public int hammingWeight(int n) {

        int count = 0;
        while (n != 0) {
            count += n & 1; // Check if the last bit is 1
            n >>= 1; // Right shift n by 1 position (logical shift for unsigned numbers)
        //⭐There is difference between n >>>= 1 and n >>= 1, as first one doesn't preserve sign while the later does.
        // n >>>= 1 shifts the bits of n to the right and fills the leftmost bit with 0, regardless of whether n is positive or negative.
        // n >>= 1 Shifts the bits of n to the right, and fills the leftmost bit with the sign bit (0 if the number is positive, 1 if the number is negative).
        }

        return count;
    }
}

// TC: O(log n) For an integer n, the number of binary digits required is O(logn), where the base of the logarithm is 2
// (but base is ignored in Big-O notation).
// Every integer n can be represented in binary, and the number of bits needed to represent n is proportional
// to the logarithm of n in base 2. This is because: Number of bits in 𝑛 = log2(𝑛) + 1
// SC: O(1)