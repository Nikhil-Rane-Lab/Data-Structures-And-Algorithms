package DSA.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-k-pairs-with-smallest-sums
public class L373FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> (nums1[a[0]] + nums2[a[1]])));

        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[]{i, 0}); //(index in nums1, index in nums2)
        }

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int i = pair[0];
            int j = pair[1];
            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{i, j + 1});
            }
        }

        return result;
    }
}


// TC: O(klogk)
// Heap Operations: We maintain a heap of size at most k.
// Each insertion and extraction operation on the heap takes O(logk) time.
// Overall Operations: In the worst case, we perform k extractions and insertions, resulting in O(klogk) time complexity.

// SC: O(k)
// The heap stores at most k pairs, leading to O(k) space usage.