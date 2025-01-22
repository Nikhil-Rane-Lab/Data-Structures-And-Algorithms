package DSA.array;

//https://leetcode.com/problems/longest-common-prefix
public class L14LongestCommonPrefix {

//Explanation of Prefix Updates:
//1) Start with the first string as the initial prefix.
//2) Gradually reduce the prefix length until it matches the beginning of the current string.
//3) Continue until the prefix matches all strings.
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start with the first string as the prefix
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // Find the common prefix between prefix and strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                // Reduce the prefix length by one character
                prefix = prefix.substring(0, prefix.length() - 1);
                // If prefix becomes empty, return empty string
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
// SC: O(N * M) : where N is the number of strings in the array and M is the length of the shortest string in the array.
// TC: O(1)