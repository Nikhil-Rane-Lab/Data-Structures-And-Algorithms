package DSA.stack;

import java.util.Stack;

public class L20ValidParanthesis {

    public static boolean isValid(String s) {

        // Edge case: null or odd-length strings cannot be valid
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If stack is empty or the top of stack does not match
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets are properly matched
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}

// TC: O(N)
// SC: O(N)
