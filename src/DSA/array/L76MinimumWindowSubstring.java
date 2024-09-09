package DSA.array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring
public class L76MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
            return "";
        }

        // Step 1: Create frequency map for characters in t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int matchedCount = 0;  // Number of characters that have met their frequency in t
        int start = 0; // Track the start of the minimum window

        // Map to track characters in the current window
        Map<Character, Integer> windowMap = new HashMap<>();

        // Step 2: Use two pointers and a sliding window
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // Step 3: Check if we have met the condition for current character
            if (tMap.containsKey(rightChar) && tMap.get(rightChar).intValue() == windowMap.get(rightChar).intValue()) {
                matchedCount++;
            }

            // Step 4: Shrink the window from the left if all characters are matched
            while (matchedCount == tMap.size()) {
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;  // Update the minimum window
                    start = left; // Remember the start of the minimum window
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.getOrDefault(leftChar, 0) - 1);

                // Check if this reduces the count of a necessary character
                if (tMap.containsKey(leftChar) && tMap.get(leftChar).intValue() > windowMap.get(leftChar).intValue()) {
                    matchedCount--;
                }

                left++; //move the left pointer
            }
            right++; //move the right pointer
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}

//TC: O(m+n) as building the frequency map of t takes O(n), where n is the length of t
// AND The sliding window uses two pointers (left and right), each traversing the string s exactly once, resulting in O(m), where m is the length of s.

//SC: O(m+n) We use two hash maps (one for t and one for the sliding window), which at most store 26 characters
// (in case both s and t are made up of unique lowercase or uppercase letters).
// This results in O(1) space for the maps, but considering the length of the strings,
// it’s O(m + n) in the worst case due to the storage for tMap and windowMap.