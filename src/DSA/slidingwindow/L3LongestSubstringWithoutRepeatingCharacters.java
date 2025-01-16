package DSA.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters
public class L3LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String str) {
        // Edge case: if the string is empty
        if (str == null || str.isEmpty()) {
            return 0;
        }

        // Using a sliding window with a HashSet
        Set<Character> seen = new HashSet<>();
        int left = 0;
        int maxLength = Integer.MIN_VALUE;

        for (int right = 0; right < str.length(); right++) {
            char currChar = str.charAt(right);

            // If the character is already in the set, remove characters from the left
            while (seen.contains(currChar)) {
                seen.remove(str.charAt(left));
                left++;
            }

            seen.add(currChar);  // Add the current character to the set
            maxLength = Math.max(maxLength, right - left + 1); // Update the max length
        }

        return maxLength;
    }
//TC: O(N) where n is the length of the string s. Each character is processed at most twice (once by right (for adding)
// and once by left (for removing)), resulting in O(N)

//SC: O(min(n, m))
//        - n is the length of the input string.
//        - m is the size of the character set (e.g., 26 for lowercase English letters, 128 for ASCII).
//        - In the worst case, the HashSet stores all unique characters from the input string, but its size is capped by m.


    public static int lengthOfLongestSubstringTimeOptimised(String s) {
        // Edge case: if the string is empty
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Using a HashMap to store the latest index of each character
        Map<Character, Integer> charToIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the map and its last seen index is within the current window.
            // Instead of incrementing left step by step,
            // the HashMap allows us to directly jump the left pointer to skip over the duplicate character.
            // It reduces unnecessary iterations to adjust the left pointer,
            // especially for long strings with repeated characters.
            if (charToIndexMap.containsKey(currentChar) && charToIndexMap.get(currentChar) >= left) { // checking if the character is already in the map and its last seen index is within the current window.
                left = charToIndexMap.get(currentChar) + 1; // Move left to avoid the duplicate
            }

            // Update the latest index of the current character
            charToIndexMap.put(currentChar, right);

            // Update the max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
//TC: O(N) where n is the length of the string s. Each character is processed at most twice (once by right (for adding)
// and once by left (for removing)), resulting in O(N)

//SC: O(min(n, m))
//        - n is the length of the input string.
//        - m is the size of the character set (e.g., 26 for lowercase English letters, 128 for ASCII).
//        - In the worst case, the HashSet stores all unique characters from the input string, but its size is capped by m.
}

