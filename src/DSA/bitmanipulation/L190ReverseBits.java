package DSA.bitmanipulation;

//https://leetcode.com/problems/reverse-bits/description
public class L190ReverseBits {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;  // Left shift result to make space for the next bit
            result |= n & 1; // Get the least significant bit of n and add it to the result
            n >>= 1;  // Right shift n to process the next bit
        }
        return result;
    }
}

// TC: O(1) The loop runs 32 times, so the time complexity is O(1)
// since it always processes a fixed number of bits (32).

//SC: O(1) because we only use a constant amount of extra space (for variables result and i).