package DSA.linkedlist;

//https://leetcode.com/problems/merge-two-sorted-lists
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode listA, ListNode listB) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (listA != null && listB != null) {
            if (listA.val <= listB.val) {
                tail.next = listA;
                listA = listA.next;
            } else {
                tail.next = listB;
                listB = listB.next;
            }
            tail = tail.next;
        }

        //only one list can be non-null
        if (listA != null) {
            tail.next = listA; //as the list is already sorted we can directly append the list at the end
        } else {
            tail.next = listB; //same as above
        }

        // Return the merged list, which is next to the dummy node
        return dummy.next;
    }

    /**
     TC: O(n+m) where n = listA's lenght and m = listB's length. Since each node from both lists is processed exactly once, the total number of operations is proportional to the sum of the lengths of the two lists.
     SC: O(1)
     */
}
