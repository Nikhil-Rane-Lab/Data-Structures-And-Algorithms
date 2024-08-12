package DSA.linkedlist;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
public class L82RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) { //means we have found a duplicate like [1,1,1,1,....]
                // Skip all nodes with the same value
                while (head.next != null && head.val == head.next.val) {//Move head to the end of duplicates sublist
                    head = head.next;
                }

                prev.next = head.next; // Skip the last node of the duplicate group. Skip all duplicates. Refer ⚠️
            } else {
                prev = prev.next; //prev is used to connect nodes that are confirmed to be non-duplicates.
                //⚠️ The reason it is not done above in the "if" block is because the next element which we know is not-duplicate
                // (i.e., not 1) may be duplicate of its own kind, like it may be giving rise to a series of 2's ([2,2,2...])
                //or series of 3's like ([3,3,3...]) etc
            }

            head = head.next;
        }

        return dummy.next;
    }

    //TC: O(n)
    //SC: O(1)
}
