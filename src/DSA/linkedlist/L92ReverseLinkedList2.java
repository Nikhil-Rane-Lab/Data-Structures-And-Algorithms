package DSA.linkedlist;

import java.util.Stack;

//https://leetcode.com/problems/reverse-linked-list-ii
public class L92ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to handle edge cases where reversing starts at the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move `pre` to the node just before the reversing part
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next; // `curr` will point to the beginning of the part to be reversed
        ListNode next = curr.next; // `next` will point to the node that will be moved during the reversing process

        // Reverse the sublist from left to right
        // in every iteration of the below loop prev will be unchanged and curr will be
        // unchanged.
        for (int i = 0; i < right - left; i++) {
            curr.next = next.next; // curr's ONLY purpose is to temporarily store the "next.next" to increment
            // next by one position in every iteration
            next.next = prev.next; // make "next" as the 1st node of the subsection as the second element
            prev.next = next; // append next to the curr of the sub-section
            next = curr.next; // now curr serves its purpose by giving "next" to "next" (incrementing next)
        } //MNEMONIC: CNNP:PNNC (mirror image) with only "next" in last two (Cartoon Network No Problem 😂)

        return dummy.next;
    }
    //TC: O(N)
    //SC: O(1)

    public ListNode reverseBetweenUsingStack(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move `pre` to the node just before the reversing part
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
