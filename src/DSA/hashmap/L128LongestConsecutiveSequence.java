package DSA.hashmap;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-consecutive-sequence
public class L128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        int longestStreak = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) { // Only start counting if it's the start of a (new) sequence
                int currNum = num;
                int currStreak = 1;

                // Count consecutive numbers
                while (set.contains(num + 1)) {
                    num = num + 1;
                    currStreak++;
                }

                longestStreak = Math.max(currStreak, longestStreak);
            }
        }

        return longestStreak;
    }
}
//TC: O(n)
//SC: O(n)