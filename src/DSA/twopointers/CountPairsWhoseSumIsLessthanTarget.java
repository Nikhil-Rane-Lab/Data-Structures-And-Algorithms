package DSA.twopointers;

import java.util.List;

//https://www.geeksforgeeks.org/problems/count-pairs-in-a-sorted-array-whose-sum-is-less-than-target/1
public class CountPairsWhoseSumIsLessthanTarget {

    public int solve(List<Integer> numsList, int target) {

        int left = 0;
        int right = numsList.size() - 1;
        int count = 0;

        while (left < right) {
            if (numsList.get(left) + numsList.get(right) < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    // TC: O(n), as each element is processed at most twice.
    // SC: O(1)

    public int solve2(List<Integer> numsList, int target) {

        int count = 0;
        for (int i = 0; i < numsList.size() - 1; i++) {
            for (int j = i + 1; j < numsList.size(); j++) {
                if (numsList.get(i) + numsList.get(j) < target) {
                    count++;
                }
            }
        }

        return count;
    }
}
