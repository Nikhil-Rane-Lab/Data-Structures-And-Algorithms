package DSA.linkedlist.other;

import DSA.linkedlist.ListNode;

//https://leetcode.com/problems/reverse-linked-list
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next; // Store the next node
            curr.next = prev; // Reverse the link
            prev = curr;      // Move prev forward
            curr = next;      // Move curr forward
            // 🚀 Mnemonic : NCCP : PCCN
        }

        return prev; // New head of the reversed list 🚀
    }

    //TC: O(n)
    //SC: O(1)
}
