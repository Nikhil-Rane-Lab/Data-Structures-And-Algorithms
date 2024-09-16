package DSA.math;

//https://leetcode.com/problems/factorial-trailing-zeroes
public class L172FactorialTrailingZeroes {

    //To count the number of trailing zeroes in the factorial of a number n, we need to consider how trailing zeroes are
    // formed. Trailing zeroes are produced by multiplying factors of 10, and a factor of 10 is produced by multiplying
    // 2 and 5. Since the number of 2s is always greater than or equal to the number of 5s in the factorial decomposition,
    // the number of trailing zeroes is determined by the number of 5s in the prime factors of the numbers from 1 to n.
    public int trailingZeroes(int n) {

        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n; //⭐ Memorise
        }

        return count;
    }
}
// TC: O(log5n)
// SC: O(1)
