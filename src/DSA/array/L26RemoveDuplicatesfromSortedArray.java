package DSA.array;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array
public class L26RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        // Edge case: If array length is 1, return 1
        if (nums.length == 1) {
            return 1;
        }

        // Initialize two pointers
        int uniqueIndex = 0; // Tracks position for unique elements

        for (int i = 1; i < nums.length; i++) {
            // If a new unique element is found
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++; // Move the unique index
                nums[uniqueIndex] = nums[i]; // Update the position with the new unique value
            }
        }

        // The number of unique elements is uniqueIndex + 1
        return uniqueIndex + 1;
    }
}

// TC: O(N)
// SC: O(1)
