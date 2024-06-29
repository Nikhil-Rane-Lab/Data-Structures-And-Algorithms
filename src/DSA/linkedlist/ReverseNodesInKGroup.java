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
            } //MNEMONIC: CNNP:PNNC (mirror image) with only "next" in last two (Cartoon Network No Problem 😂)

            prev = curr;
            count -= k;
        }

        return dummy.next;
    }

    //The second while loop runs through the list and processes k nodes at a time.
    // Each group of k nodes is reversed in O(k) time.
    // Since we process the entire list and each node is visited and manipulated a constant number of times,
    // this loop also takes O(n) time in total.
    //TC: O(n)
    //SC: O(1)
}
