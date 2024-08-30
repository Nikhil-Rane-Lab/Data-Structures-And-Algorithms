package DSA.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/
public class L46Permutations {
//https://www.youtube.com/watch?v=YK78FU5Ffjw
//https://www.youtube.com/watch?v=f2ic2Rsc9pU

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, new ArrayList<>());
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> tempArr) {
        if (tempArr.size() == nums.length) {
            result.add(new ArrayList<>(tempArr));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempArr.contains(nums[i])) {
                    continue;
                }
                tempArr.add(nums[i]);
                backtrack(result, nums, tempArr);
                tempArr.remove(tempArr.size() - 1);
            }
        }
    }

    //TC: O(N * N!), where N is the number of elements in nums.
    // This is because there are N! permutations,
    // and it takes O(N) time to copy each permutation to the result list.

    //SC: O(N * N!) to store the result plus O(N) for the recursion stack, leading to a total of O(N * N!) space.
}
