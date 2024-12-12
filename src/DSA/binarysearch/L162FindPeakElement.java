package DSA.binarysearch;

//https://leetcode.com/problems/find-peak-element/description
public class L162FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

// TC: O(log n), where n is the length of the input array nums.
//     This complexity arises because the algorithm employs a binary search strategy, which halves the search space at
//     each step until it converges on a peak element.
//     The maximum number of iterations required is proportional to the logarithm of the size of the array.
// SC: O(1)
