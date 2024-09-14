package DSA.hashmap;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/contains-duplicate-ii
public class L219ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                Integer prevIndex = indexMap.get(nums[i]);
                if (i - prevIndex <= k) {
                    return true;
                }
            }

            indexMap.put(nums[i], i);
        }

        return false;
    }

    //TC: O(n)
    //SC: O(min(n, k)) - In the worst case, the hash map stores all unique elements up to k distance apart. If k is large
    // or the number of unique elements is less, the space complexity will be up to O(n). Otherwise, it can be less, bounded by O(k).
}
