package DSA.math;

//https://leetcode.com/problems/powx-n
public class L50PowXN {

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;
        double currProduct = x;

        while (N > 0) {
            if (N % 2 == 1) {
                result *= currProduct;
            }

            currProduct *= currProduct;
            N /= 2;
        }

        return result;
    }
}
//TC: O(logn) because we are halving n at each step of the loop.
//SC: O(1)