package DSA.binarysearch;

//https://leetcode.com/problems/search-in-rotated-sorted-array
public class L33SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int middleElement = nums[mid];
            if (middleElement == target) { // Check if the mid element is the target
                return mid;
            }

            // Determine which side is sorted
            if (nums[left] <= middleElement) { // Left side is sorted
                if (nums[left] <= target && target < middleElement) {
                    right = mid - 1; // Target is in the left half
                } else {
                    left = mid + 1; // Target is in the right half
                }
            } else { // Right side is sorted
                if (middleElement < target && target <= nums[right]) {
                    left = mid + 1; // Target is in the right half
                } else {
                    right = mid - 1; // Target is in the left half
                }
            }
        }

        return -1;
    }
}

// TC: O(log n)
// SC: O(1)
