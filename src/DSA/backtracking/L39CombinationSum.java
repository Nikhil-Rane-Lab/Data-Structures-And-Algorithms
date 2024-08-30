package DSA.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum
public class L39CombinationSum {
//https://www.youtube.com/watch?v=OyZFFqQtu98

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> currList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    currList.add(candidates[i]);
                    backtrack(candidates, target - candidates[i], i, currList, result);
                    currList.remove(currList.size() - 1);
                }
            }
        }
    }
}

//TC: O (2^t), where "t" is the target value.
// The reason is that each candidate can be chosen multiple times,
// leading to a large number of possible combinations, especially when the target is large.

//SC: The space complexity is O(t), where "t" is the target value.
// This is due to the depth of the recursion stack, which can go as deep as the target value
// when the smallest candidate is 1.