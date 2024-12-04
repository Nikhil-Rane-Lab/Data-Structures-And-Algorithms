package DSA.binarytree;

//https://leetcode.com/problems/validate-binary-search-tree
public class L98ValidateBinaryTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long minValue, long maxValue) {
        if (node == null) { // here we know for sure that there is no point going further into recursion as node is null so we return true
            return true;
        }

        if (node.val <= minValue || node.val >= maxValue) { // but here we cannot return true by changing this to opposite
        // condition as we are not sure that its children nodes are valid or not. To check that we need to recurse further.
            return false;
        }

        return isValidBST(node.left, minValue, node.val) && isValidBST(node.right, node.val, maxValue);
    }

    //TC: O(N)
    //SC: O(h), where h is the height of the tree.
    // This accounts for the recursion stack in the worst case. For a balanced tree, this is O(logn);
    // for a skewed tree, it could be O(n).
}

    // storing the in-order traversal in an ArrayList and then checking if the list is in strictly
    // increasing order is another valid approach to determine whether a binary tree is a valid Binary Search Tree (BST).
    // but its SC will be O(n) which will be less efficient than above approach
