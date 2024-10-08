package DSA.binarytree;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list
public class L114FlattenBinaryTreeToLinkedList {

// 2 Approaches
//https://www.youtube.com/watch?v=sWf7k1x9XR4

    //Preferred Approach as SC: O(1)
    //💡 Morris Traversal uses inOrder traversal internally but the question expects preOrder traversal but it still works!
    public void MorrisTraversalflatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                // Find the rightmost node of the left subtree
                TreeNode rightMost = curr.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }

                // Connect the right subtree of the current node to the rightmost node of the left subtree
                rightMost.right = curr.right;
                curr.right = curr.left; // Move the left subtree to the right
                curr.left = null; // adhering to linkedlist structure
            }

            curr = curr.right;
        }
    }

    //TC: O(n)
    //SC: O(1) //due to morris traversal
    //No additional space proportional to the input size is used (such as a stack for recursive calls,
    //which would be O(h) where h is the height of the tree in a recursive approach).


    TreeNode prev = null;
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        // adhering to linkedlist structure.
        // Only one pointer contains value. In this case right pointer contains value.
        // so left pointer is always null.
        root.left = null;
        root.right = prev;
        prev = root;
    }

    //TC: O(n)
    //SC: O(h) The space complexity is due to the recursive stack space.
    //In the worst case (for a skewed tree), the space complexity is) O(n).
    //For a balanced tree, it is O(logn).
}
