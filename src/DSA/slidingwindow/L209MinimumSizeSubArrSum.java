package DSA.slidingwindow;

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

