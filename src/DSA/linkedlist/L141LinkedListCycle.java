package DSA.linkedlist;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/linked-list-cycle
public class L141LinkedListCycle {

//  Floyd's Cycle Detection algorithm, also known as the Tortoise and Hare algorithm.
    public boolean hasCycle(ListNode head) {
/*
Let the distance between the slow pointer and the fast pointer at some point inside the cycle be d steps.
Each time the slow pointer moves one step, the fast pointer moves two steps, effectively closing the gap by 1 step
(since 2 - 1 = 1). This means that the fast pointer will catch up to the slow pointer after d steps.
*/
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
    //TC: O(N)
    //SC: O(1)


    //Unoptimised Algorithm
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> visitedListNodeSet = new HashSet<>();

        while (head != null) {
            head = head.next;
            if (!visitedListNodeSet.add(head)) {
                return true;
            }
        }

        return false;
    }
    //TC: O(n)
    //SC: O(n)
}
