package DSA.divideandconquer;

import DSA.linkedlist.ListNode;

//https://leetcode.com/problems/sort-list/description
public class L148SortList {

//  Approach:
//  We need to sort a linked list in ascending order. To meet the follow-up constraint of sorting the list in O(nlogn)
//  time with constant space complexity, merge sort is the most appropriate algorithm. Merge sort divides the list into
//  two halves, sorts each half recursively, and then merges the two sorted halves.
    public ListNode sortList(ListNode head) {

        // Base case: if the list is empty or has only one node, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves
        ListNode mid = getMiddle(head);
        ListNode rightHalf = mid.next;
        mid.next = null; // break the list

        // Sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHalf);

        // Merge the two sorted halves
        return mergeList(left, right);
    }

    // Helper function to merge two sorted lists
    private ListNode mergeList(ListNode listA, ListNode listB) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (listA != null && listB != null) {
            if (listA.val <= listB.val) {
                curr.next = listA;
                listA = listA.next;
            } else {
                curr.next = listB;
                listB = listB.next;
            }

            curr = curr.next;
        }

        if (listA != null) {
            curr.next = listA;
        } else {
            curr.next = listB;
        }
        return dummy.next;
    }

    // Helper function to get the middle node of the list
    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

// TC: O(nlogn)
// i) Dividing the list into halves takes O(logn) levels of recursion.
// ii) Merging two sorted lists takes O(n) time at each level.

// SC : O(logn)
// While the merge sort algorithm typically requires O(n) auxiliary space for recursion, this can be reduced to O(1)
// space if we focus only on iterative merging operations. However, due to the recursive nature of the function,
// the space complexity here is O(logn) because of the recursion stack depth.
