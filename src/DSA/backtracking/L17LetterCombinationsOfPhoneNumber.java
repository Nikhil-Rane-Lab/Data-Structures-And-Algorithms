package DSA.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number
public class L17LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        backtrack(result, digits, "", 0, mapping);
        return result;
    }

    private void backtrack(List<String> result, String digits, String currStr, int index, String[] mapping) {
        if (currStr.length() == digits.length()) {
            result.add(currStr);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            backtrack(result, digits, currStr + letters.charAt(i), index + 1, mapping);
        }
    }

    //TC: (3^m × 4^n ), where m is the number of digits corresponding to 3 letters (like '2', '3', '4', etc.),
    // and n is the number of digits corresponding to 4 letters (like '7' and '9').
    // This is because each digit can produce multiple combinations, with 3 or 4 possibilities
    // depending on the digit.


    //SC: O(3^m × 4^n ) due to the space needed to store all combinations in the result list and the recursion stack.
}
