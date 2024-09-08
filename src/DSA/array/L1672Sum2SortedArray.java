package DSA.array;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
public class L1672Sum2SortedArray {

    //2 Pointers Approach
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{left + 1, right + 1};
    }
}
//TC: O(n) as we traverse the array only once using two pointers.
//SC: O(1)
