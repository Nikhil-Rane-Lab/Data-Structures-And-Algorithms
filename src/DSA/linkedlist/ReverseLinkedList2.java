package DSA.linkedlist;

import java.util.Stack;

public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;

        // Create a dummy node to handle edge cases where reversing starts at the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move `pre` to the node just before the reversing part
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode start = prev.next; // `start` will point to the beginning of the part to be reversed
        ListNode then = start.next; // `then` will point to the node that will be moved during the reversing process

        // Reverse the sublist from left to right
        // in every iteration of the below loop prev will be unchanged and start will be
        // unchanged.
        for (int i = 0; i < right - left; i++) {
            start.next = then.next; // start's ONLY purpose is to temporarily store the "then.next" to increment
            // then by one position in every iteration
            then.next = prev.next; // make "then" as the 1st node of the subsection as the second element
            prev.next = then; // append then to the start of the sub-section
            then = start.next; // now start serves its purpose by giving "then" to "then" (incrementing then)
        } //MNEMONIC: STTP:PTTS with then in last two

        return dummy.next;
    }
    //TC: O(N)
    //SC: O(1)

    public ListNode reverseBetweenUsingStack(ListNode head, int left, int right) {

        if (head == null || left == right)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        Stack<ListNode> listNodeStack = new Stack<>();
        // Push all nodes from left to right onto the stack
        for (int i = left; i <= right; i++) {
            listNodeStack.push(curr);
            curr = curr.next;
        }

        // Pop from stack and reverse the nodes
        while (!listNodeStack.isEmpty()) {
            prev.next = listNodeStack.pop();
            prev = prev.next;
        }

        // Connect the last part
        prev.next = curr; //⭐ no need to do curr.next here

        return dummy.next;
    }

    //TC: O(n)
    //SC: O(left-right+1)
}
