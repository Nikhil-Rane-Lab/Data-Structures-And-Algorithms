package DSA.intervals;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/summary-ranges
public class L228SummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start != nums[i]) {
                resultList.add(start + "->" + nums[i]);
            } else {
                resultList.add(String.valueOf(start));
            }
        }

        return resultList;
    }
}

//TC: O(n)
//SC: O(n)