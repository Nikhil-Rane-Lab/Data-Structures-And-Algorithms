package DSA.array;

//https://leetcode.com/problems/trapping-rain-water
public class L42TrappingRainWater {
//https://www.youtube.com/watch?v=m18Hntz4go8

    public int trap(int[] height) {

        int left = 0, right = height.length - 1;
        int rightMax = 0;
        int leftMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    waterTrapped += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    waterTrapped += (rightMax - height[right]);
                }
                right--;
            }
        }
        return waterTrapped;
    }
}

//TC: O(n)
//SC: O(1)
