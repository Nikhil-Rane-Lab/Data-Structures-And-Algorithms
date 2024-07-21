import DSA.binarytree.SumRootToLeafNumbers;
import DSA.binarytree.TreeNode;
import DSA.linkedlist.ListNode;
import DSA.linkedlist.RemoveDuplicatesFromSortedList2;

import static DSA.linkedlist.ListNode.printLinkedList;

public class Main {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        // Create an instance of Solution and call the sumNumbers method
        SumRootToLeafNumbers solution = new SumRootToLeafNumbers();
        int result = solution.sumNumbers(root);

        // Print the result
        System.out.println("Output: " + result); // Output: 1026
    }
}