package DSA.binarytree;

import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator
public class L173BinarySearchTreeIterator {

    Stack<TreeNode> stack;

    public L173BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeftNodes(root);
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
        pushAllLeftNodes(node.right);  // After visiting node, push all the left nodes of the right child
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
