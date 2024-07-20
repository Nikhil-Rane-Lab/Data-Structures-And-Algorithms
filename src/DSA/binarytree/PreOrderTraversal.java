package DSA.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
//https://www.youtube.com/watch?v=80Zug6D1_r4 (Morris Traversal)

    //* 3 Approaches (last one is the most efficient)
    //* Recursive Approach
    public List<Integer> preorderTraversal1(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();
        preOrderHelper(root, resultList);
        return resultList;
    }

    private void preOrderHelper(TreeNode node, List<Integer> resultList) {
        if (node == null) {
            return;
        }

        resultList.add(node.val);
        preOrderHelper(node.left, resultList);
        preOrderHelper(node.right, resultList);
    }

    //* Iterative Approach
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        // Push right child first so that left is processed first
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            resultList.add(node.val); // Visit the root node

            if (node.right != null) {
                nodeStack.push(node.right);
            }

            if (node.left != null) {
                nodeStack.push(node.left);
            }
        }

        return resultList;
    }

    //TC: O(n), where n is the number of nodes in the tree.
    //SC: O(h), where h is the height of the tree

    //⭐ The recursive approach uses the call stack to keep track of function calls,
    // which can lead to a stack overflow for very deep trees.
    // The iterative approach uses an explicit stack, which is stored on the heap,
    // making it less likely to run out of space.

    public List<Integer> morrisTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                //this is to handle the case in which there is no left child of the binary tree
                resultList.add(curr.val);
                curr = curr.right;
            } else {
                // Find the inorder predecessor of current
                //ie., rightmost node of the left subtree i.e., last element of inOrder traversal of left subtree
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Make current the right child of its inorder predecessor i.e., create a thread of threaded binary tree
                    predecessor.right = curr;
                    resultList.add(curr.val); //* ⭐ This will come in the lower 'else' condition for inOrder traversal. No other change.
                    curr = curr.left;
                } else {
                    // Revert the changes made in the 'if' part to restore the original tree
                    predecessor.right = null; //remove the thread
                    curr = curr.right;
                }
            }
        }

        return resultList;
    }

    //TC: O(n)
    //SC: O(1)
}
