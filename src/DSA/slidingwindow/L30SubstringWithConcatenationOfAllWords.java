package DSA.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/substring-with-concatenation-of-all-words
public class L30SubstringWithConcatenationOfAllWords {

    //Does Not give TLE on Leetcode
    public List<Integer> findSubstringOptimised(String str, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (str == null || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;
        if (str.length() < totalLength) {
            return result;
        }

        // Create a map to store the frequency of each word in words
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Slide over the string in steps of wordLength
        for (int i = 0; i < wordLength; i++) { // ⭐ this is because any word of fixed size (wordLength) can start from any position of any word itself
            int left = i, right = i;
            Map<String, Integer> seenMap = new HashMap<>();
            int matchedWords = 0;

            // Move the window by wordLength each time
            while (right + wordLength <= str.length()) {
                String substring = str.substring(right, right + wordLength);
                right += wordLength;

                if (wordMap.containsKey(substring)) {
                    seenMap.put(substring, seenMap.getOrDefault(substring, 0) + 1);
                    matchedWords++;

                    // If the word appears more times than it should, shrink the window
                    while (seenMap.get(substring) > wordMap.get(substring)) {
                        String leftWord = str.substring(left, left + wordLength);
                        seenMap.put(leftWord, seenMap.get(leftWord) - 1);
                        matchedWords--;
                        left += wordLength;
                    }

                    // If the number of matched words is equal to wordCount, record the result
                    if (matchedWords == wordCount) {
                        result.add(left);
                    }
                } else {
                    left = right;
                    seenMap.clear();
                    matchedWords = 0;
                }
            }
        }
        return result;
    }

    //TC:  O(n), where n is the length of the string s.
    // We loop through the string s wordLength times, and for each starting position,
    // we perform a sliding window operation that processes each word in the string exactly once.

    //SC: O(m+n) Where m is the number of words in words[] and n is the length of the string str.
    // as we use a hash map to store the frequency of words, which takes O(m) space,
    // where m is the number of distinct words in words.

    //Gives TLE on Leetcode
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - totalLength; i++) {

            int j = 0;
            Map<String, Integer> seenMap = new HashMap<>();

            while (j < words.length) {

                int wordStartIndex = i + j * wordLength;
                String substring = s.substring(wordStartIndex, wordStartIndex + wordLength);

                if (!wordMap.containsKey(substring)) {
                    break;
                }

                seenMap.put(substring, seenMap.getOrDefault(substring, 0) + 1);
                if (seenMap.get(substring) > wordMap.get(substring)) {
                    break;
                }

                j++;
            }

            if (j == words.length) {
                result.add(i);
            }
        }

        return result;
    }
}
//TC: O(n * m)
// Constructing the word frequency map takes O(m), where m is the number of words.
// The sliding window approach runs over s and processes each word in the substring,
// which gives a complexity of O(n * m), where n is the length of the string s and m is the number of words.

//SC: O(m)
