package DSA.array;

//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
public class L28FindTheIndexOfTheFirstOccurrenceInAString {

    // APPROACH 1: Less Time Optimal:
    public int strStrLessOptimal(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        if (needleLen > haystackLen) { // If needle is longer than haystack, it cannot be found
            return -1;
        }

        for (int i = 0; i <= haystackLen - needleLen; i++) {  // Check every substring of haystack with the same length as needle
            if (haystack.substring(i, i + needleLen).equals(needle)) { // Compare substring with needle
                return i; // Found needle, return index
            }
        }

        return -1; // Needle not found in haystack
    }

// TC: O(n * m) in the worst case since substring and equals take O(m) time.
// For each starting position, we compare up to m characters.

// SC: O(1), as no extra space (apart from variables) is used.

    // APPROACH 2: More Time Optimal:
    public int strStrMoreOptimal(String haystack, String needle) {
        // If needle is empty, return -1 as per the problem statement
        if (needle.isEmpty()) {
            return -1;
        }

        // Use indexOf to find the first occurrence of needle in haystack
        return haystack.indexOf(needle);
    }

// TC:  O(n + m) in the average case, where n is the length of haystack and m is the length of needle.
// Internally, indexOf uses an efficient algorithm like Knuth-Morris-Pratt (KMP) for substring matching.

// SC: O(1), as we are only using a constant amount of extra space.
}
