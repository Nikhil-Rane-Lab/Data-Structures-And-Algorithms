package DSA.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/ipo/description
public class l502IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        // Min-heap to store projects based on capital requirements
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Max-heap to store projects based on profit
        PriorityQueue<int[]> maxProfitHeap = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));

        // Push all projects into the min-heap
        for (int i = 0; i < capital.length; i++) {
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }

        // Perform at most k selections of projects
        for (int i = 0; i < k; i++) {
            // Move all projects whose capital requirements are <= current capital `w` to the max-heap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.poll()[0] > w) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            // If there's no project we can afford, break the loop
            if (maxProfitHeap.isEmpty()) {
                break;
            }

            // Choose the most profitable project available
            w += maxProfitHeap.poll()[1];
        }

        return w;
    }
}

// TC: O(nlogn+klogn)
// Building the heaps takes O(nlogn), where n is the number of projects.
// In each of the k iterations, we may move elements between the heaps and extract from the max-heap, each taking O(logn).

// SC: O(n) as we use two heaps, each storing up to n elements.