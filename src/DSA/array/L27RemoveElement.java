package DSA.array;

//https://leetcode.com/problems/remove-element/description
public class L27RemoveElement {

    public int removeElement(int[] nums, int val) {
        int k = 0; // Pointer to track the number of elements not equal to val

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Move non-val elements to the front
                k++;
            }
        }

        return k;
    }
}

// TC: O(n)
// SC: O(1)
