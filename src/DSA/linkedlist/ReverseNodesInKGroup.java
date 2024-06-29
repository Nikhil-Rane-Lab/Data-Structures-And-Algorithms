package DSA.linkedlist;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy, curr = dummy, next = dummy;
        int count = 0;

        // Count the number of nodes in the linked list
        while (curr.next != null) { //🌟 whenever we need curr.next to be non-null in the later stage of the program,
                                    // we use this curr.next != null for counting the number of elements in the LL
            count++;
            curr = curr.next;
        }

        while (count > k) {
            curr = prev.next;
            next = curr.next;

            // Loop through the list, reversing in k-group chunks
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }

            prev = curr;
            count -= k;
        }

        return dummy.next;
    }
}
