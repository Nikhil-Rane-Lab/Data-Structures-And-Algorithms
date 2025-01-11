package DSA.linkedlist;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
public class L82RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head; // 💡 this is to avoid NPE if initial elements in the sequence are unique
        ListNode prev = dummy;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) { //means we have found a duplicate like [1,1,1,1,....]
                // Skip all nodes with the same value
                while (head.next != null && head.val == head.next.val) {//Move head to the end of duplicates sublist
                    head = head.next;
                }

                prev.next = head.next; // Skip the last node of the duplicate group. Skip all duplicates. Refer ⚠️
                // prev.next because head.next although is a new number can be series of its own kind.
            } else {
                prev = prev.next; // prev is used to connect nodes that are confirmed to be non-duplicates.
                //⚠️ This isn't done in the "if" block because the next non-duplicate element (e.g., not 1) could itself start
                // a new series of duplicates of different number, like 2's ([2, 2, 2...]) or 3's ([3, 3, 3...]) etc.
            }

            head = head.next;
        }

        return dummy.next;
    }

    //TC: O(n)
    //SC: O(1)
}
