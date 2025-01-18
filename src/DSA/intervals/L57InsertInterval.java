package DSA.intervals;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/insert-interval
public class L57InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int i = 0; // ⭐ same i is used till last loop without being reset
        int n = intervals.length;

        // Step 1: Add all intervals that end before newInterval starts.
        while (i < n && intervals[i][1] < newInterval[0]) { // ⭐ memorize
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]); // whichever is having earlier start, set it as start of newInterval
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]); // whichever is having later end, set it as end of newInterval
            i++;
        }
        result.add(newInterval);

        // Step 3: Add all intervals that start after newInterval ends
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
// TC: O(n)
// SC: O(n)