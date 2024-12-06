package DSA.binarytree.other;

import DSA.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Q) https://leetcode.com/problems/binary-tree-inorder-traversal
public class InOrderTraversal {
    //* 3 Approaches (3 rd one is the most efficient)

    //* Recursive Approach
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        inOrderHelper(root, resultList);
        return resultList;
    }

    private void inOrderHelper(final TreeNode node,
                               final List<Integer> result) {
        if (node != null) {
            inOrderHelper(node.left, result);
            result.add(node.val);
            inOrderHelper(node.right, result);
        }
    }

    //* Iterative Approach
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode currNode = root;

        while (currNode != null || !nodeStack.isEmpty()) {
            while (currNode != null) {
                nodeStack.push(currNode);
                currNode = currNode.left;
            }

            currNode = nodeStack.pop();
            resultList.add(currNode.val);
            currNode = currNode.right;
        }
        return resultList;
    }

    //TC and SC Both Approaches have same TC and SC
    //TC: The time complexity is O(n), where n is the number of nodes in the tree. This is because each node is visited exactly once.
    //SC: Space Complexity (SC): The space complexity is O(h), where h is the height of the tree.
    //This space is used by the recursion stack.
    //⭐In the worst case (for a completely unbalanced tree), the height h can be n.
    //⭐For a balanced tree, h would be O(logn).

    //* Morris Traversal Approach O(1) Space
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
                    curr = curr.left;
                } else {
                    // Revert the changes made in the 'if' part to restore the original tree
                    predecessor.right = null; //remove the thread
                    resultList.add(curr.val); //* ⭐ This will come in the upper 'if' condition for preOrder traversal. No other change.
                    curr = curr.right;
                }
            }
        }

        return resultList;
    }

    //TC: O(n)
    //SC: O(1)
}
