package DSA.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/merge-intervals
public class L56MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by the starting time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); //⭐ Memorise

        List<int[]> merged = new ArrayList<>();
        int[] currInterval = intervals[0];

        // Add the first interval to the list
        merged.add(currInterval);

        for (int[] interval : intervals) {
            int currEnd = currInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currEnd) {
                // Overlap exists, merge intervals
                currInterval[1] = Math.max(nextEnd, currEnd);
            } else {
                // No overlap, update currInterval and add to the merged list
                currInterval = interval;
                merged.add(currInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}

//TC: O(nlogn) due to sorting, and O(n) for the iteration,
// resulting in an overall time complexity of O(nlogn).

//SC: O(n) for storing the result in the merged list.
