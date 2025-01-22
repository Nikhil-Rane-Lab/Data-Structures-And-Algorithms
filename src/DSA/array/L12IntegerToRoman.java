package DSA.array;

//https://leetcode.com/problems/integer-to-roman
public class L12IntegerToRoman {

    public String intToRoman(int num) {

        //⭐this has to be in descending order of values
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Integer[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) { // 💡 we are iterating over values
            while (num >= values[i]) { // 🚀 this is "while" loop not "if" condition
                num -= values[i];
                sb.append(romanSymbols[i]);
            }
        }

        return sb.toString();
    }
}

//TC: O(1) because the input is constrained to a maximum of 3999, so the loop runs a fixed number of iterations for any valid input.
//SC: O(1) since only a constant amount of extra space is used for storing the result and mapping arrays.
