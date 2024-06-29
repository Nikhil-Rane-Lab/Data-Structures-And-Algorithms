package DSA.linkedlist;

//https://leetcode.com/problems/partition-list
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        // These pointers will help to build the new lists
        ListNode less = lessDummy; //⭐ we are not directly using lessDummy as we have to send (so have to store) its start as the final answer
        ListNode greater = greaterDummy; //⭐ we are not directly using greaterDummy as we have to append it (its start) to the end of the "less" LL

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }

            head = head.next;
        }

        greater.next = null;           // End the greater list
        less.next = greaterDummy.next; // Connect the less list with the greater list

        return lessDummy.next; // Return the head of the less list, skipping the dummy node
    }

//    TC: O(n)
//    SC: O(1)
}