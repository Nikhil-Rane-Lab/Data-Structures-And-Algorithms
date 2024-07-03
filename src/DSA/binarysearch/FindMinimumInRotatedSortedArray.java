package DSA.binarysearch;

//Q) https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // If the middle element is greater than the rightmost element, then the
            // minimum is in the right part.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid; // Otherwise, the minimum is in the left part including the middle element.
            }
        }

        // The loop exits when left == right, pointing to the smallest element.
        return nums[left];
    }

    //* TC: O(log n)
    //* SC: O(n)
}
