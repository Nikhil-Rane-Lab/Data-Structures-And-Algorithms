package DSA.hashmap;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/isomorphic-strings
public class L205IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sToTMap = new HashMap<>();
        Map<Character, Character> tToSMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // Check if sChar is already mapped to a different tChar
            if (sToTMap.containsKey(sChar)) {
                if (sToTMap.get(sChar) != tChar) {
                    return false;
                }
            } else {
                sToTMap.put(sChar, tChar);
            }

            // Check if tChar is already mapped to a different sChar
            if (tToSMap.containsKey(tChar)) {
                if (tToSMap.get(tChar) != sChar) {
                    return false;
                }
            } else {
                tToSMap.put(tChar, sChar);
            }
        }

        return true;
    }

// TC: O(n) as we iterate through the strings once.
// SC: O(1) as the hash maps will store at most 256 mappings (the number of ASCII characters).
}
