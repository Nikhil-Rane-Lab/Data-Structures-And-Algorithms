package DSA.array;

//https://leetcode.com/problems/rotate-array
public class L189RotateArray {

    //2 Approaches
    //Most Optimised using constant space
    public void rotate(int[] nums, int k) {

        int length = nums.length;

        k = k % length; //⚠️Handle cases where k is larger than the array size

        // Step 1: Reverse the entire array
        reverseArraySection(nums, 0, length - 1);

        // Step 2: Reverse the first k elements
        reverseArraySection(nums, 0, k - 1);

        // Step 3: Reverse the remaining n-k elements
        reverseArraySection(nums, k, length - 1);
    }

    private void reverseArraySection(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //TC: O(n)
    //SC: O(1)

    //Less Optimised using O(n) space
    public void rotate2(int[] nums, int k) {

        int length = nums.length;
        int[] temp = new int[length];
        k = k % length;

        for (int i = 0; i < length; i++) {
            temp[(i + k) % length] = nums[i]; //⚠️Memorize
        }

        for (int i = 0; i < length; i++) {
            nums[i] = temp[i];
        }
    }
}
