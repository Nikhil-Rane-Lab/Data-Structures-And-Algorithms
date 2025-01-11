package DSA.linkedlist;

//https://leetcode.com/problems/rotate-list
public class L61RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 1; //⚠️
        ListNode curr = head;

        while (curr.next != null) { //⭐The reason we have given this condition instead of while (curr != null) to
                                    // calculate length of LL is because we want the "curr" to be non-null
            curr = curr.next;
            len++;
        }

        k = k % len; //😱 ⚠️ it is not (len % k) as we generally think that numerator should be higher than denominator
                     // which DOES NOT apply in this case!
        if (k == 0) {
            return head; // do nothing, return LL as it is
        }

        int numOfStepsToReachNewTail = len - k;

        curr.next = head; //⭐ to make the LL circular but this is not the tail of the final answer
        ListNode newTail = head;

        //⭐ here we first find the tail of the rotated LL and then its head
        for (int i = 1; i < numOfStepsToReachNewTail; i++) { // 🚀 (int i = 1)
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next; //"newHead" is the new head of the rotated LL
        newTail.next = null; //"newTail" is the tail of the new rotated LL so its next must be null
        return newHead;
    }

    //TC: O(n)
    //SC: O(1)
}
