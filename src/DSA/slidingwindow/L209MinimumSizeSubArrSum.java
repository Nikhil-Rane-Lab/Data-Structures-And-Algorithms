package DSA.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-size-subarray-sum
public class L209MinimumSizeSubArrSum {

    public int minSubArrayLen(int target, int[] nums) {
        // Edge case: if nums is empty
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int currSum = 0;

        // Shrink the window while the sum is greater than or equal to the target
        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right]; // Add the current element to the sum

            while (currSum >= target) {
                minLen = Math.min(minLen, (right - left) + 1); // +1 is done to compensate for 0 based indexing
                currSum -= nums[left];
                left++; //⭐ refer comment
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen; // Return 0 if no valid subarray is found
    }

/**
  ⭐ this is done because now we know the minLength once we "start" with index 0.
  Now no point in considering "start" as iterating the outer loop i.e., incrementing end will only increase the length
  i.e., (end-start+1) which is not what we want.
  So we will simply discard now "start" by incrementing it.

  One interesting observation here is that "end" remains unchanged for changed "start" because we know that if we increment
  "start" then the window is contracted and so anyway we will get the next "minLen"


 TC: O(n)  // Both pointers (start and end) move from the beginning to the end of the array at most once, resulting in a linear time complexity.
 SC: O(1)
 */

// APPROACH 2

    // https://www.notion.so/DSA-13c8604c11f380559d5cdacadeb95087?pvs=4#17d8604c11f380afb9c4eb77eb81dbe7
    public int minSubArrayLenBinarySearch(int target, int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int requiredSum = target + prefixSum[i];
            int j = Arrays.binarySearch(prefixSum, requiredSum);
            if (j < 0) j = -j - 1; // Adjust for binary search's negative return value

            if (j <= n) {
                minLength = Math.min(minLength, j - i);
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    //TC: O(nlogn)
    //SC: O(n)
}
