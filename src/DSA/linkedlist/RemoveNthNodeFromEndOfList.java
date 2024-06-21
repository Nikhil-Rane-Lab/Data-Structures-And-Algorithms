package DSA.linkedlist;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = head;
        int len = 0;
        while (dummy != null) {
            len++;
            dummy = dummy.next;
        }

        dummy = head;
        if (len == n) { //it means we have to remove head of the LL
            return head.next;
        }
        for (int i = 1; i < (len - n); i++) {
            dummy = dummy.next;
        }

        dummy.next = dummy.next.next;
        return head;
    }

    //TC: O(n)
    //SC: O(1)


    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Special case: If first becomes null, it means n is equal to the size of the linked list
        // Hence, the node to remove is the head itself
        if (first == null) {
            return head.next;
        }

        // Move first to the end, maintaining the gap of n nodes between first and second
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        //now second is pointing to the node to be removed
        // Remove the nth node from the end
        second.next = second.next.next;
        return dummy.next;
    }

    //TC: O(n)
    //SC: O(1)
}
