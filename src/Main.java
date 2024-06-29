import DSA.linkedlist.ListNode;
import DSA.linkedlist.RemoveDuplicatesFromSortedList2;

import static DSA.linkedlist.ListNode.printLinkedList;

public class Main {
    public static void main(String[] args) {

        int[] values1 = {1, 1,1,2, 3,3, 4, 5};
        ListNode head1 = ListNode.createLinkedList(values1);
        System.out.print("Original List: ");
        printLinkedList(head1);
        ListNode result1 = new RemoveDuplicatesFromSortedList2().deleteDuplicates(head1);
        System.out.print("Reversed List (2, 4): ");
        printLinkedList(result1);
    }
}