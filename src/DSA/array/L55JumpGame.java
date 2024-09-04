package DSA.array;

//https://leetcode.com/problems/jump-game
public class L55JumpGame {

    //Greedy Approach
    public boolean canJump(int[] nums) {

        int maxReach = 0; //represents the maximum index to which you can jump based on whatever values you have seen till now.
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) { //⚠️it means this index was not reachable in the first place by jumping
                                //  from any other index
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]); //only update the maxReach if you know that
            //jumping from the current index leads to more reach/distance than "maxReach".
        }

        return true; //it means that last index is reachable as the entire for-loop got completed
        //without encountering even a single index that was unreachable in the jumps.
    }

    //TC: O(N)
    //SC: O(1)
}
