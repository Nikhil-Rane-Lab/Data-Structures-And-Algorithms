package DSA.array;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
public class L80RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k < 2 || nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}

//TC: O(n) where n is the number of elements in nums.
//SCL: O(1) as we are modifying the array in place without using extra space.
