package DSA.array;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
public class L80RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {

        // Edge case: If the array has less than 3 elements, it's already valid.
        if (nums.length <= 2) {
            return nums.length;
        }

        int i = 2;  // Start from the 3rd element
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;  // The length of the array after duplicates are removed
    }
}

//TC: O(n) where n is the number of elements in nums.
//SCL: O(1) as we are modifying the array in place without using extra space.
