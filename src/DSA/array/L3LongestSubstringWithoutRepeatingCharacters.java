package DSA.array;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters
public class L3LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String str) {

        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;

        while (right < str.length()) {
            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(str.charAt(left));
                left++;
            }
        }

        return maxLength;
    }
}

//TC: O(N) where n is the length of the string s. Each character is added and removed from the set at most once.
//SC: O(min(n, m)) where m is the character set size. In the worst case, the set stores all unique characters from the input string.
