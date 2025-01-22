package DSA.other;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/roman-to-integer/
public class L13RomanToInteger {

    public static int solve(String str) {
        Map<Character, Integer> charToValueMap = new HashMap<>();
        charToValueMap.put('I', 1);
        charToValueMap.put('V', 5);
        charToValueMap.put('X', 10);
        charToValueMap.put('L', 50);
        charToValueMap.put('C', 100);
        charToValueMap.put('D', 500);
        charToValueMap.put('M', 1000);

        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            Integer currValue = charToValueMap.get(str.charAt(i));

            if (i + 1 < str.length()) {
                Integer nextValue = charToValueMap.get(str.charAt(i + 1));
                if (currValue < nextValue) {
                    total -= currValue;
                } else {
                    total += currValue;
                }
            } else {
                total += currValue;
            }
        }

        return total;
    }

/*
To convert a Roman numeral to an integer in Java, you can follow these steps:

I)    Create a mapping of Roman numeral characters to their integer values.
II)   Iterate through the characters of the Roman numeral string.
III)  For each character, if its value is less than the value of the next character, subtract it from the total; otherwise, add it to the total.
IV)   If last element, then simply add its value to the total
*/
}
