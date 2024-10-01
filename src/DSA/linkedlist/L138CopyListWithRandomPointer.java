package DSA.linkedlist;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/copy-list-with-random-pointer
public class L138CopyListWithRandomPointer {
//In this we simply have to make a (deep) copy of the original list such that no node in the new copied list
// (be it "node" itself, its "next" pointer or its "random" pointer) points to (i.e., reuse) any node in the original list.
// means all nodes related to new list should be brand-new nodes.

    public Node copyRandomList(Node head) {
        Node original = head;

        Map<Node, Node> originalToCopyMap = new HashMap<>();
        while (original != null) {
            originalToCopyMap.put(original, new Node(original.val));
            original = original.next;
        }
        //originalToCopyMap also has all the nodes that are being pointed to by the random pointer,
        //as in question it is given that the random pointer points to any node "IN" the list, or null.

        original = head;
        while (original != null) {
            Node copyNode = originalToCopyMap.get(original);
            copyNode.next = originalToCopyMap.get(original.next); //⭐if original.next is null then hashMap will not give NPE but will return null which is desirable.
            copyNode.random = originalToCopyMap.get(original.random);
            original = original.next;
        }

        return originalToCopyMap.get(head); //⭐ returning the head of the NEW COPIED LIST
    }

    // TC: O(N)
    // SC: O(N)

    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
