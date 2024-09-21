package DSA.divideandconquer;

import DSA.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists/description
public class L23MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val)); //⭐ memorise

        // Add the head of each list to the heap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        // Dummy node to help build the result list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            // Get the smallest node
            ListNode smallest = minHeap.poll();
            curr.next = smallest;
            curr = curr.next;

            // If there is a next node, add it to the heap
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;  // Return the merged list starting from the next of dummy
    }
}
// NOTE: A priority queue is a special type of queue where each element is assigned a priority, and the element with the
// highest priority (in this case, the smallest value) is dequeued first.
// By default, Java’s PriorityQueue sorts elements in ascending order (for a min-heap).
// So, the element with the smallest value is always at the front of the queue.
// A min-heap is a binary heap where the parent node is always less than or equal to its children. In the context of the
// PriorityQueue, it maintains this order internally, ensuring that the smallest element is always at the root.

// TC: O(Nlogk)
// Heap Operations: Each of the k lists can have a maximum of n nodes, so the total number of nodes is N
// (where N is the total number of nodes across all lists).
// Each insertion and extraction operation in the heap takes O(logk).

// SC: O(k) for the heap, as we store at most k nodes at any time.