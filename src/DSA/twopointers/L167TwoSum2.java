package DSA.twopointers;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class L167TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};
    }
}

//TC: O(N) Each element moves at most N steps
//SC: O(1) No additional space is used except for variables.