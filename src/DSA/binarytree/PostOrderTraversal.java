package DSA.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-postorder-traversal
public class PostOrderTraversal {
//* 2 Approaches

    //* Recursive Approach
    public List<Integer> postorderTraversal1(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();
        postorderHelper(root, resultList);
        return resultList;
    }

    private void postorderHelper(TreeNode node, List<Integer> resultList) {
        if (node != null) {
            postorderHelper(node.left, resultList);
            postorderHelper(node.right, resultList);
            resultList.add(node.val);
        }
    }

    /**
     TC: O(n) The time complexity of the postorder traversal algorithm is O(n), where n is the number of nodes
     in the binary tree. This is because the algorithm visits each node exactly once.
     SC: O(n)
     Recursion Stack:
     In the worst case, the height of the tree could be O(n) (for example, in a skewed tree where each node has only one child).
     In the best case, for a balanced tree, the height would be O(logn).
     Therefore, the space complexity for the recursion stack is O(h), where h is the height of the tree.
     */

    //* Iterative Approach
    public List<Integer> postOrderTraversal2(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            TreeNode currNode = nodeStack.pop();
            resultList.add(0, currNode.val); //⭐

            if (currNode.left != null) {
                nodeStack.push(currNode.left);
            }

            if (currNode.right != null) {
                nodeStack.push(currNode.right);
            }
        }

        return resultList;
    }

    //TC O(n), where n is the number of nodes in the binary tree.
    //SC: O(n), due to the stack used for iterative traversal and the output list.
    //For balanced Binary tree, the SC will O(log n) as although it will still hold all the elements
    //of the tree but not simultaneously
 }
