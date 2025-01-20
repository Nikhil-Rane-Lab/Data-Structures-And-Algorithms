package DSA.array;

//https://leetcode.com/problems/jump-game-ii
public class L45JumpGame2 {
//https://www.youtube.com/watch?v=9kyHYVxL4fw

    public int jump(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }
        int jumps = 0; // Tracks the number of jumps needed.
        int farthest = 0; // The farthest index reachable overall while iterating
        int currentEnd = 0; // The farthest index reachable with the current number of jumps

        for (int i = 0; i < nums.length; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current jump range
            if (currentEnd == i) {
                jumps++;
                currentEnd = farthest;

                // If the currentEnd is already at or beyond the last index
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }
}
//TC: O(N)
//SC: O(1)
