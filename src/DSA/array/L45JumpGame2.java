package DSA.array;

//https://leetcode.com/problems/jump-game-ii
public class L45JumpGame2 {
//https://www.youtube.com/watch?v=9kyHYVxL4fw

    public int jump(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }
        int jumps = 0;
        int farthest = 0;
        int current_end = 0;

        for (int i = 0; i < nums.length; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (current_end == i) {
                jumps++;
                current_end = farthest;

                if (current_end >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }
}
//TC: O(N)
//SC: O(1)
