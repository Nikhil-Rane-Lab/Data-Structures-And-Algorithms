package DSA.binarytree;

import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator
public class L173BinarySearchTreeIterator {

    Stack<TreeNode> stack;

    public L173BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    //TC: O(h) for initialization and O(1) amortized for next() and O(1) for hasNext().
    //SC: O(h) - where h is the height of the binary search tree.
}
