package DSA.kadanesalgorithm;

//https://leetcode.com/problems/maximum-sum-circular-subarray
public class MaximumSumCircularSubArray {

    public int maxSubarraySumCircular(int[] nums) {

        int linearMaxKadane = kadane(nums);

        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        //simply substituting each arr element by (-1 * itself)
        // Invert the array elements to find the minimum subarray sum
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }

        int invertedMaxKadane = kadane(nums);
        int maxCircular = totalSum + invertedMaxKadane;

        // If all elements are negative, maxCircular will be 0, which means the non-circular max is better
        if (maxCircular == 0) {
            return linearMaxKadane;
        }

        return Math.max(linearMaxKadane, maxCircular);
    }

    private int kadane(int[] nums) {
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], nums[i] + maxCurrent);
            maxGlobal = Math.max(maxCurrent, maxGlobal);
        }

        return maxGlobal;
    }

    //TC: O(n)
    //SC: O(1)
/*
To solve the problem of finding the maximum sum of a subarray in a circular array, we need to consider two main scenarios:

1. The subarray with the maximum sum is a regular, non-circular subarray.
2. The subarray with the maximum sum is a circular subarray, which wraps around the end of the array and connects back to the beginning.

To achieve this, we can use Kadane's algorithm, which efficiently finds the maximum sum subarray in linear time.

Here are the steps we need to follow:

1. Use Kadane's algorithm to find the maximum sum subarray in the non-circular case.
2. Calculate the total sum of the array and use Kadane's algorithm to find the minimum sum subarray.
   The maximum sum for the circular case can be derived by subtracting the minimum sum subarray from the total sum.
3. Compare the results of the non-circular maximum sum and the circular maximum sum to get the final result.
   However, we need to handle the edge case where all elements are negative, as in this case, the circular subarray would include the entire array, which is not allowed.
*/
}