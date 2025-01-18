package DSA.intervals;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
public class L452MinimumNumberofArrowstoBurstBalloons {

    public int findMinArrowShots(int[][] points) {

        if (points.length == 0) {
            return 0;
        }

        // Sort balloons by their end points
        Arrays.sort(points, Comparator.comparingInt(a -> a[1])); // 🚀 Memorise
        int arrowsCount = 1; // ⭐ We need at least one arrow.
        // We assume the first arrow is shot at the end of the first balloon.
        int lastPosition = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the last arrow position, shoot a new arrow
            if (points[i][0] > lastPosition) {
                arrowsCount++;
                lastPosition = points[i][1];  // Update the arrow position
            }
        }

        return arrowsCount;
    }
}
// TC: O(nlogn)
// Sorting the points array takes O(n log n), where n is the number of balloons.
// The subsequent traversal through the sorted array takes O(n).
// Hence, the overall time complexity is O(n log n).

// SC: O(1)