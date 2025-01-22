package DSA.array;

import java.util.Arrays;

//https://leetcode.com/problems/candy
public class L135Candy {

    //2 Pass Greedy Approach

// Approach:
// First Pass (Left to Right): We traverse the ratings array from left to right.
// If a child has a higher rating than the previous child, they get one more candy than the previous child.

// Second Pass (Right to Left): We traverse the ratings array from right to left.
// If a child has a higher rating than the next child, they get one more candy than the next child,
// but we also make sure to keep the larger value between what we set in the first pass and what we're assigning now.

// Finally, we sum up all the candies to get the minimum number of candies required.
    public int candy(int[] ratings) {

        int childrenCount = ratings.length;
        int[] candies = new int[childrenCount];

        // Give each child 1 candy initially
        Arrays.fill(candies, 1);

        // First pass: Left to Right
        for (int i = 1; i < childrenCount; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1; //⭐
            }
        }

        // Second pass: Right to Left
        for (int i = childrenCount - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1); //⭐
            }
        }

        // Sum up all the candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}

//TC: O(N)
//SC: O(N)
