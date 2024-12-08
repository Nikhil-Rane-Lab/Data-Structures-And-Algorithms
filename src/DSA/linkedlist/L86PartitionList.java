package DSA.linkedlist;

//https://leetcode.com/problems/partition-list
public class L86PartitionList {
//In this question, we have to rearrange the original linked list in such a way that all the elements which are strictly
//lesser than X should come before X and maintain the relative order within themselves.
//Then we have to simply return the remaining list maintaining the relative order within themselves.
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
        less.next = greaterDummy.next; // Connect the end of less list with the start of greater list

        return lessDummy.next; // Return the head of the less list, skipping the dummy node
    }

//    TC: O(n)
//    SC: O(1)
}

/*
a) Any number that is less than x has to be before x, and maintain the relative order with those that are less than x
but already before x. e.g. [3,4,1,2], target = 4 -> [3,1,2,4], so the order of [3,1,2] is maintained.

b) Any number that is greater than x but already before x will still be before x, but all of them come after those
   that are less than x and at the same time maintain their relative order.
e.g. [3,6,5,4,1,2] target = 4 -> [3,1,2,6,5,4]

c) Any number that is greater than x and after x will only need to maintain their relative order
e.g. [3,6,5,4,8,1,7,2] target = 4 -> [3,1,2,6,5,4,8,7]
Hope this helps those who have a difficulty time understanding "all nodes less than x come before nodes greater than or equal to x." like me.
*/