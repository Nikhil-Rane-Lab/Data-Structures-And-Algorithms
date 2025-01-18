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
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); //🚀 Memorise

        List<int[]> merged = new ArrayList<>();
        int[] currInterval = intervals[0]; //💡 We are adding this to final result although it may be a part of
        // "to-be-merged" interval because we can still change its value by changing currInterval[1] later.

        // Add the first interval to the list
        merged.add(currInterval);

        for (int[] interval : intervals) { // will work even if we iterate from i = 1
            int currEnd = currInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currEnd) {
                // Overlap exists, merge intervals
                currInterval[1] = Math.max(nextEnd, currEnd);
            } else {
                // No overlap, update currInterval and add to the merged list
                currInterval = interval;
                merged.add(currInterval); //💡 same as above comment we are adding this to final result although
                // it may be a part of "to-be-merged" interval because we can still change its value by changing currInterval[1] later.
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}

//TC: O(nlogn) due to sorting, and O(n) for the iteration,
// resulting in an overall time complexity of O(nlogn).

//SC: O(n) for storing the result in the merged list.
