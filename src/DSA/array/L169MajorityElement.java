package DSA.array;

//https://leetcode.com/problems/majority-element
public class L169MajorityElement {
//https://www.notion.so/DSA-13c8604c11f380559d5cdacadeb95087?pvs=4#1808604c11f3802490d6c9ac67ad61fe
// 🚀 Boyer-Moore Voting Algorithm

    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        // First pass: Find the majority candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Return the candidate (guaranteed to be the majority element)
        return candidate;
    }
}

// TC: O(N)
// SC:: O(1)
