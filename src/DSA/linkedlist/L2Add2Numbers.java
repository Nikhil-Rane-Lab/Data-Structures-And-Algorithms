package DSA.linkedlist;

//https://leetcode.com/problems/add-two-numbers
public class L2Add2Numbers {

    //instead of adding from right to left, we are adding from left to right as the numbers are reversed
    //as linkedList can only be traversed in forward direction
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the head of the result list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;

        // Traverse both lists and the carry, continue until both lists and carry are exhausted
        while (list1 != null || list2 != null || carry != 0) {
            int sum = carry; //⭐ not sum += carry

            if (list1 != null) {
                sum += list1.val;
                list1 = list1.next;
            }

            if (list2 != null) {
                sum += list2.val;
                list2 = list2.next;
            }

            curr.next = new ListNode(sum % 10);
            carry = sum / 10; //Update carry for next iteration
            curr = curr.next;
        }
        return dummy.next; // Return the next node of dummy, which is the head of the result list
    }

    //TC: O(max(m,n)), where 𝑚 and 𝑛 are the lengths of list1 and list2 respectively.
    //SC: O(max(m,n))
}
