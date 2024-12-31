package DSA.twopointers;

//https://leetcode.com/problems/container-with-most-water
public class L11ContainerWithMostWater {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int currMinHeight = Math.min(height[left], height[right]); // minimum height decides the height of rectangle
            // as water will anyway overflow above it irrespective of the other taller line
            int currArea = currMinHeight * width; // area of rectangle = (length + breadth)
            maxArea = Math.max(currArea, maxArea); // maxArea = maxWaterStored between two lines denoted by two pointers

            if (height[left] < height[right]) { // Move the pointer pointing to the shorter line towards the other pointer
            // to potentially find a taller line that can form a larger area.
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    //TC: O(N)
    //SC: O(1)
}
