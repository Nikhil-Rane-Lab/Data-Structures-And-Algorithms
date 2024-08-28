package DSA.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations
public class L77Combinations {

    public List<List<Integer>> combine(int n, int maxCombinationLength) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, maxCombinationLength);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currCombination, int start, int n, int maxCombinationLength) {
        if (currCombination.size() == maxCombinationLength) {
            result.add(new ArrayList<>(currCombination));
            return;
        }

        for (int i = start; i <= n; i++) {
            currCombination.add(i);
            backtrack(result, currCombination, i + 1, n, maxCombinationLength);
            currCombination.remove(currCombination.size() - 1);
        }
    }
}
