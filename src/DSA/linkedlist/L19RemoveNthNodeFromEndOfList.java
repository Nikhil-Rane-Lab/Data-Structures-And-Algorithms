package DSA.linkedlist;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list
public class L19RemoveNthNodeFromEndOfList {

    // APPROACH: Use two pointers (Leader-Follower Approach)
    // Move "Leader" pointer N steps forward.
    // Then move "Leader" to the end, maintaining the gap of n nodes between first and second
    public ListNode removeNthFromEndOptimisedSinglePass(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;  // ⭐ this is to handle if the node to be removed is head itself
        ListNode leader = dummy, follower = dummy;

        // Move leader ahead by 💡"n+1" NOT "n" steps to maintain the gap between leader and follower
        for (int i = 0; i <= n; i++) { //🚀 memorize because (n+1) steps so more iterations should be there
            leader = leader.next;
        }

        // Move both leader and follower until leader reaches the end
        while (leader != null) { //💡
            // if the node to be removed is head itself then this while loop will not run
            leader = leader.next;
            follower = follower.next;
        }

        follower.next = follower.next.next;
        return dummy.next;
    }
    //TC: O(n)
    //SC: O(1)

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
}
