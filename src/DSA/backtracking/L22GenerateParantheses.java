package DSA.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses
public class L22GenerateParantheses {
//https://www.youtube.com/watch?v=s9fokUqJ76A

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String curr, int openCount, int closeCount, int maxCount) {

        if (curr.length() == maxCount * 2) {
            result.add(curr);
            return;
        }

        if (openCount < maxCount) {
            backtrack(result, curr + "(", openCount + 1, closeCount, maxCount);
        }

        if (closeCount < openCount) {
            backtrack(result, curr + ")", openCount, closeCount + 1, maxCount);
        }
    }
}

//TC: O(4^n / √n) because each valid sequence corresponds to a Catalan number,
// and the n-th Catalan number is approximately 4^n / (n * √n).

//SC: O(n), considering the depth of the recursion stack.