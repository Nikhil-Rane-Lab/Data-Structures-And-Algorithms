package DSA.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Q) https://leetcode.com/problems/binary-tree-inorder-traversal
public class InOrderTraversal {
    //* 2 Approaches

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
}
