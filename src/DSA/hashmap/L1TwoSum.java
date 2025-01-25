package DSA.hashmap;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/description
public class L1TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If the complement exists in the map, return the pair of indices
            if (numToIndexMap.containsKey(complement)) {
                return new int[]{numToIndexMap.get(complement), i};
            }

            // Otherwise, add the current number and its index to the map
            numToIndexMap.put(nums[i], i);
        }

        return new int[0];
    }

// TC: O(n) because we are only iterating through the array once.
// SC: O(n) due to hashmap at most storing n elements
}
