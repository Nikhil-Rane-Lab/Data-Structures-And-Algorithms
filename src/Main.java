import DSA.linkedlist.L82RemoveDuplicatesFromSortedList2;
import DSA.linkedlist.ListNode;

public class Main {
    public static void main(String[] args) {

        ListNode head = createLinkedList(new int[] {1, 1,2,2, 3, 3, 4});
        ListNode listNode = new L82RemoveDuplicatesFromSortedList2().deleteDuplicates(head);
    }

    // Helper method to create a linked list from an array
    public static ListNode createLinkedList(int[] nums) {
        if (nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }

}
