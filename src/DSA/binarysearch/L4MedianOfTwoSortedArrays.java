package DSA.binarysearch;

//https://leetcode.com/problems/median-of-two-sorted-arrays
public class L4MedianOfTwoSortedArrays {
// https://www.youtube.com/watch?v=yD7wV8SyPrc

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1); //do binary search on lesser size array for efficiency
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0;
        int high = n1; //⭐

        while (low <= high) {
            // cut1 represents the partition point in nums1, dividing it into two parts: the left half and the right half.
            // cut1 determines how many elements from nums1 are in the left partition.
            int cut1 = low + (high - low) / 2;
            int cut2 = ((n1 + n2 + 1) / 2) - cut1; //⭐ This represents the partition point in nums2.
//          cut2 is automatically determined based on cut1. The sum of elements on the left side of the partition from
//          both nums1 and nums2 should be equal to the total number of elements divided by 2 (for even lengths)
//          or half + 1 (for odd lengths).

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1]; // The last element on the left side of the partition in nums1.
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1]; // The last element on the left side of the partition in nums2.

            int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1]; // The first element on the right side of the partition in nums1.
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2]; // The first element on the right side of the partition in nums2.

            if (l1 <= r2 && l2 <= r1) {
                // We have partitioned correctly
                if ((n1 + n2) % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return (double) Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                // it means we have too many elements from nums1 on the left, so we move cut1 to the left by adjusting high.
                high = cut1 - 1;
            } else {
                // it means we don't have enough elements from nums1 on the left, so we move cut1 to the right by adjusting low.
                low = cut1 + 1;
            }
        }

        return 0;
    }
}

// TC: O(log(min(m,n))) because we perform binary search on the smaller of the two arrays.
// SC: O(1) since we are using a constant amount of extra space.
