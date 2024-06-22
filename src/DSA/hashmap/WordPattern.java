package DSA.hashmap;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/word-pattern
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {

        String[] strArr = str.split(" ");

        if (strArr.length != pattern.length()) { // IMP condition
            return false;
        }

        Map<Character, String> charToStringMap = new HashMap<>();
        Map<String, Character> strToCharMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char currChar = pattern.charAt(i);

            String currWord = strArr[i];
            if (charToStringMap.containsKey(currChar)) {
                String expectedString = charToStringMap.get(currChar);
                if (!expectedString.equals(currWord)) {
                    return false;
                }
            } else {
                if (strToCharMap.containsKey(currWord)) {
                    Character expectedChar = strToCharMap.get(currWord);
                    if (expectedChar != currChar) {
                        return false;
                    }
                }
                charToStringMap.put(currChar, currWord);
                strToCharMap.put(currWord, currChar);
            }
        }

        return true;
    }

    //TC: O(n)
    //SC: O(n)
    //Note map.containsValue() takes O(N) time as it does linear search internally

}
