package DSA.hashmap;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/ransom-note/
public class L383RansomeNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];  // Create an array to store the frequency of characters in the magazine

        // Increment the frequency for each character in magazine
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (freq[c - 'a'] == 0) {
                return false;  // Character not available or insufficient count
            }

            freq[c - 'a']--; // Reduce the count for the character
        }

        return true; // All characters of ransomNote are available in magazine
    }
// ⭐ This solution is efficient than below because we avoid the overhead of HashMap operations (which involve hashing and rehashing.
// TC: O(n+m)
// Counting characters in magazine: O(n), where n is the length of magazine.
// Checking characters in ransomNote: O(m), where m is the length of ransomNote.

// SC: O(1)
// The array size is fixed at 26 (for all lowercase English letters), which is) O(1) space.

    public boolean canConstructLessOptimal(String ransomNote, String magazine) {
        // Create a frequency map for the characters in the magazine
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Check if the ransom note can be constructed
        for (char c : ransomNote.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) <= 0) {
                return false; // Character not found or insufficient count
            }
            charCount.put(c, charCount.get(c) - 1); // Reduce the count for the character
        }
        return true;
    }

// TC: O(n+m)
// Building the frequency map for magazine takes O(n), where n is the length of magazine.
// Checking each character of ransomNote against the map takes O(m), where 𝑚 m is the length of ransomNote.

// SC: O(1)
// The frequency map will use space proportional to the number of unique characters in magazine.
// This is O(26), which simplifies to O(1) since there are only 26 lowercase English letters.
}

