package DSA.hashmap;

import java.util.*;

//https://leetcode.com/problems/group-anagrams
public class L49GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedStrToAnagramStrsMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String sortedStr = new String(charArray);
            if (!sortedStrToAnagramStrsMap.containsKey(sortedStr)) {
                sortedStrToAnagramStrsMap.put(sortedStr, new ArrayList<>());
            }

            List<String> anagramStrs = sortedStrToAnagramStrsMap.get(sortedStr);
            anagramStrs.add(str);
        }

        return new ArrayList<>(sortedStrToAnagramStrsMap.values());
    }
}

//TC: O(n⋅mlogm)
// Sorting each string takes O(mlogm), where m is the length of the string.
// We do this for each string in the array, so the total time complexity is O(n⋅mlogm),
// where n is the number of strings in the array.

//SC: O(n*m) as in worst case we can save each string (n strings) as key (sorted string)
// in hashmap where m is maximum length of any string.