package DSA.binarysearch;

//* https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
public class L34FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int ans = -1; //⚠️

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid; //⚠️ we do not break the loop once the target is found, we keep on iterating till the loop naturally ends.
            }
            if (nums[mid] >= target) { //⚠️ NOTE: here even if (nums[mid] == target) still we are doing (right = mid - 1),
                                    // which means we will keep searching in the left half of the array even if we find the target
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private int findLast(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                index = mid;
            }
            if (nums[mid] <= target) { //⚠️ NOTE: here even if (nums[mid] == target) still we are doing (left = mid + 1),
                // which means we will keep searching in the right half of the array even if we find the target
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    //TC: O(log n)
    //SC: O(1)
}
