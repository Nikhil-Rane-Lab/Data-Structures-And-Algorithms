package DSA.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii
public class L117PopulatingNextRightPointersInEachNode2 {
//https://www.youtube.com/watch?v=afORAzOLV_g (Less Space Optimal)

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node curr = root;

//      The outer while loop runs as long as there are nodes to process at the current level.
        while (curr != null) {
            Node dummy = new Node(0);  // Dummy node to track the start of the next level
            Node tail = dummy; // Tail node to build the next level's linked list

            // Traverse the CURRENT level and connect nodes for the next level
            while (curr != null) {

                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }
                curr = curr.next;
            }

            // Move to the next level
            curr = dummy.next;
        }

        return root;
    }
    //TC: O(N)
    //SC: O(1) The extra space used is constant because we only use a few pointers (current, dummy, and tail)
    // regardless of the number of nodes in the tree.

    public Node connectLessOptimal(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Node nextRightNode = null;
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();
                node.next = nextRightNode;
                nextRightNode = node;

                if (node.right != null) { //⭐VVIMP: RIGHT node always needs to be added first in the queue THEN the LEFT ndode
                    queue.offer(node.right);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }

        return root;
    }

    //TC: O(N)
    //SC: O(N)

    // Definition for a Node.
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
