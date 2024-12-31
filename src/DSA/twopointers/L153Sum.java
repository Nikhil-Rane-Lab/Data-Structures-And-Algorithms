package DSA.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/description
public class L153Sum {
//https://www.notion.so/DSA-13c8604c11f380559d5cdacadeb95087?pvs=4#16d8604c11f380219eb6ef93a518c59f

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums); //⭐

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1; //⭐
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resultList;
    }
}

// TC: O(n^2) https://www.notion.so/DSA-13c8604c11f380559d5cdacadeb95087?pvs=4#16d8604c11f380219eb6ef93a518c59f
// SC: O(1), excluding the space required for the output.