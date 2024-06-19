package DSA.slidingwindow;

//https://leetcode.com/problems/minimum-size-subarray-sum
public class MinimumSizeSubArrSum {

    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int currSum = 0;

        for (int end = 0; end < nums.length; end++) {
            currSum += nums[end];

            while (currSum >= target) {
                minLen = Math.min(minLen, (end - start) + 1); // +1 is done to compensate for 0 based indexing
                currSum -= nums[start];
                start++; // II)
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

/**
  II) this is done because now we know the minLength once we "start" with index 0.
  Now no point in considering "start" as iterating the outer loop i.e., incrementing end will only increase the length
  i.e., (end-start+1) which is not what we want.
  So we will simply discard now "start" by incremening it.

  One interesting observation here is that "end" remains unchanged for changed "start" because we know that if we increment
  "start" then the window is contracted and so anyway we will get the next "minLen"


 TC: O(n)  // Both pointers (start and end) move from the beginning to the end of the array at most once, resulting in a linear time complexity.
 SC: O(1)
 */