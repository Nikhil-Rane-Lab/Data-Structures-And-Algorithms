package DSA.linkedlist;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/linked-list-cycle
public class LinkedListCycle {

    //TODO 2 approaches
//  Floyd's Tortoise and Hare algorithm
    public boolean hasCycle(ListNode head) {

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
