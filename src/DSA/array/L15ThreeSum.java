package DSA.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum
public class L15ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate `i` values
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;


                    // Skip duplicates for left pointers
                    while (left < right) {
                        if (nums[left] == nums[left - 1]) {
                            left++;
                        } else {
                            break;
                        }
                    }

                    // Skip duplicates for right pointers
                    while (left < right) {
                        if (nums[right] == nums[right + 1]) {
                            right--;
                        } else {
                            break;
                        }
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
