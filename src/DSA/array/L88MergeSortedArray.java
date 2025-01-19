package DSA.array;

//https://leetcode.com/problems/merge-sorted-array/description
public class L88MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for nums1
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for the last position in nums1

        // Merge nums1 and nums2 starting from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 is not fully merged, copy remaining elements to nums1
        while (j >= 0) { // 💡
            nums1[k--] = nums2[j--];
        }
    }
}

// Time Complexity: O(m + n) because we are iterating through both arrays once.
// Space Complexity: O(1) since we are modifying nums1 in place without using extra space.