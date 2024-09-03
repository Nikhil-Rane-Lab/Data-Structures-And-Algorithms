package DSA.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/longest-increasing-subsequence
public class L300LongestIncreasingSubsequence {
//https://www.youtube.com/watch?v=on2hvxBXJH4

    //With built-in binary search
    public int lengthOfLIS(int[] nums) {
        List<Integer> result = new ArrayList<>(); //⭐result will NOT store Longest Increasing Subsequence (LIS)
        //but still its size gives the final answer ie., length of LIS!

        for (int num : nums) {
            int pos = binarySearch(result, num); //⚠️ input list MUST be sorted for binary search which here is
            // guaranteed NOT due to input but because our algorithm works in such a way that the list is built
            // in a sorted manner!
            if (pos < 0) {
                pos = -(pos + 1);//⚠️this is because the built-in Binary Search function returns such index when the
                // target element is not present in its input list.
            }

            if (pos < result.size()) {
                result.set(pos, num);
            } else {
                result.add(num);
            }
        }
        return result.size();
    }

    //With Manual Binary Search
    public int lengthOfLIS2(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            int pos = binarySearch(result, num);
            if (pos < result.size()) {
                result.set(pos, num);
            } else {
                result.add(num);
            }
        }
        return result.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }
}

//TC:O(nlog(n))
//SC: O(n)
