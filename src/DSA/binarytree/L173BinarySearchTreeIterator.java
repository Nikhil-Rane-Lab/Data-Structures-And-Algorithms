package DSA.binarytree;

import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator
public class L173BinarySearchTreeIterator {

    Stack<TreeNode> stack;
    // Stack-based in-order traversal: We maintain a stack to simulate the recursion in an in-order traversal.
    // Initially, we push all the left nodes from the root down to the leftmost node onto the stack.
    // next(): When next() is called, we pop the top node from the stack (which will be the next smallest element),
    // and if this node has a right child, we push all the left nodes of the right subtree onto the stack.
    // This simulates inOrder traversal (left -> root -> right) order

    public L173BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeftNodes(root); //⚠️ this node is included while pushing the left nodes in the stack
    }

    /** Push all the left nodes of a subtree to the stack */
    private void pushAllLeftNodes(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        pushAllLeftNodes(node.right);  // ⚠️ this is right child. Also this node is included while pushing the left nodes in the stack
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    //TC: O(1) for initialization and O(1) amortized for next() and O(1) for hasNext(). Few operations might be costly,
    // but those costs are balanced out across many operations.
    //SC: O(h) - The space complexity is determined by the height of the tree,
    // as the stack only stores nodes along the path from the root to the current node's leftmost descendant.
}
