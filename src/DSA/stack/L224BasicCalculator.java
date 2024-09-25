package DSA.stack;

import java.util.Stack;

//https://leetcode.com/problems/basic-calculator
public class L224BasicCalculator {

    public int calculate(String str) {

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);

            // Parse the number
            int num = 0;
            if (Character.isDigit(currChar)) {
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + str.charAt(i) - '0';
                    i++;
                }
                i--; // Adjust for extra increment from inner loop
                result += (num * sign);  // Apply sign to current number
            } else if (currChar == '+') {
                sign = 1; // Next number is positive
            } else if (currChar == '-') {
                sign = -1; // Next number is negative
            } else if (currChar == '(') {
                // Push the current result and sign onto the stack. Order of Insertion matters!
                stack.push(result);
                stack.push(sign);

                // Reset for new expression inside parentheses
                result = 0;
                sign = 1;
            } else if (currChar == ')') {
                // Calculate result inside parentheses and pop sign and previous result
                result = (stack.pop() * result) + stack.pop();
            }
        }

        return result;
    }
}
// TC: O(n) where n is the length of the string s. We process each character once.
// SC: O(n) due to the stack, which may hold up to n/2 elements in the worst case (all parentheses).