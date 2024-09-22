package DSA.heap;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array
public class L215KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {

        // Create a min-heap with size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Add elements to the min-heap
        for (int num : nums) {
            minHeap.offer(num);

            // If the heap exceeds size k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the min-heap is the kth largest element
        return minHeap.peek(); // return minHeap.poll() will also work
    }
}

// TC: O(nlogk)
// For each element, we add it to the heap (which is  O(logk)) and remove the smallest
// element when needed.
// Since we process all 𝑛 n elements, the total time complexity is O(nlogk).

// SC: O(k) The heap stores at most k elements,