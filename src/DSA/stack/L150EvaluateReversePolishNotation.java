package DSA.stack;

import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation
public class L150EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                Integer b = stack.pop(); // ⭐ the order of operand matter for "-" and "/" so second operand is popped first
                Integer a = stack.pop(); // pop first operand
                int result = 0;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;

                    case "-":
                        result = a - b;
                        break;

                    case "*":
                        result = a * b;
                        break;

                    case "/":
                        result = a / b;
                        break;
                }

                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    //TC: O(n), where n is the number of tokens. We process each token exactly once
    //SC: O(n), where n is the number of tokens. In the worst case, all tokens are numbers, and we store them all in the stack.
}
