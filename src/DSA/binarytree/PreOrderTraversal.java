package DSA.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    //* 2 Approaches
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
}
