package DSA.kadanesalgorithm;

//https://leetcode.com/problems/maximum-subarray
public class L53MaxSubArray {

    public int L53MaxSubArray(int[] nums) {

        int maxCurrent = nums[0]; // initialized to the first element of the array.
                                  // This variable will store the maximum sum of the subarray "ending at the current position".
        int maxGlobal = nums[0];  // this is also initialized to the first element of the array.
                                  // This variable will store the maximum sum of any subarray "found so far".

        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);// This step decides whether to start a new subarray
            // at the current element or to extend the existing subarray to include the current element.
            // Essentially it means that if adding something (i.e., maxCurrent) to nums[i] is doing more harm than good
            // (ie., sum is less than num[i] alone) then simply do not add it to the existing subArraySum (i.e., maxCurrent),
            // instead start a new subArrSum starting from num[i]
            maxGlobal = Math.max(maxCurrent, maxGlobal);
        }

        return maxGlobal;
    }

    //TC: O(N)
    //SC: O(1)
}
