package DSA.DynamicProgramming;

//https://leetcode.com/problems/climbing-stairs
public class L70ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

//TC: O(n) - We only need to compute the result for each step once, so the time complexity is linear.
//SC: O(n) - We are using an array of size n+1 to store the results.