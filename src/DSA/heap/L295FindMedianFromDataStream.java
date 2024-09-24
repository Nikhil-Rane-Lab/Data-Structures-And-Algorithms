package DSA.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream
public class L295FindMedianFromDataStream {

    // Max-heap: stores the smaller half, uses reverse order to act as a max-heap
    PriorityQueue<Integer> maxHeap;
    // Min-heap: stores the larger half, default is a min-heap
    PriorityQueue<Integer> minHeap;

    public L295FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Balance the heaps if necessary
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        //⭐use peek() not poll() as we have to keep elements for next calls too!
        if (maxHeap.size() > minHeap.size()) { // If maxHeap has more elements, the median is its top element
            return maxHeap.peek();
        } else {
            // If both heaps have the same size, the median is the average of both top elements
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}

// TC: O(logn) per insertion, O(1) per median query.
// addNum(int num): Each time a number is added, it is inserted into one of the two heaps (maxHeap or minHeap),
// which takes O(logn), where n is the current number of elements in the heap. Balancing the heaps also
// takes O(logn).
// findMedian(): Finding the median takes O(1), as we are simply accessing the top elements of the heaps.
// To find the median, we simply access the top element of one or both heaps (using peek()), which takes
// O(1) since the heaps are already balanced.

// SC: O(n) Both heaps store all the elements that have been added so far,
// so the space complexity is proportional to the total number of elements.