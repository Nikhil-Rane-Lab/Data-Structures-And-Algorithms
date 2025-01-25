package DSA.hashmap;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/word-pattern
public class L290WordPattern {
    public boolean wordPattern(String pattern, String str) {

        String[] words = str.split(" ");
        if (words.length != pattern.length()) { // ⭐
            return false;
        }

        Map<Character, String> charToWordMap = new HashMap<>();
        Map<String, Character> wordToCharMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (charToWordMap.containsKey(ch)) {
                if (!charToWordMap.get(ch).equals(word)) {
                    return false;
                }
            } else {
                charToWordMap.put(ch, word);
            }

            if (wordToCharMap.containsKey(word)) {
                if (wordToCharMap.get(word) != ch) {
                    return false;
                }
            } else {
                wordToCharMap.put(word, ch);
            }
        }

        return true;
    }

// TC: O(n) is the length of the pattern (and also the number of words in s since both must be the same).
// The splitting of the string and the iteration through both the pattern and words takes linear time.
// SC: O(n) We use two hash maps to store the mappings, each with a size proportional to the number of
// unique characters in pattern and the number of unique words in s.
}
