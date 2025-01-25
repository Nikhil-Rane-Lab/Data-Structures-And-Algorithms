package DSA.hashmap;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/valid-anagram
public class L242ValidAnagram {

    //This approach will also work for unicode characters in String
    public boolean isAnagramBetter(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charToCountMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            charToCountMap.put(c, charToCountMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!charToCountMap.containsKey(c)) {
                return false;
            }

            charToCountMap.put(c, charToCountMap.get(c) - 1);
            if (charToCountMap.get(c) == 0) {
                charToCountMap.remove(c);
            }
        }

        return charToCountMap.isEmpty();
    }
    //TC: O(N)
    //SC: O(1) for the character count because the number of possible characters (lowercase English letters) is fixed
    // at 26. However, in the general case (like Unicode), the space complexity will be O(n).

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
//            freq[c - 'a']--; ⭐ we can add this statement to avoid below for-loop
        }

        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    //TC: O(n)
    //SC: O(1)
}
