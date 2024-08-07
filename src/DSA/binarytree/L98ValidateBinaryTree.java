package DSA.binarytree;

//https://leetcode.com/problems/validate-binary-search-tree
public class L98ValidateBinaryTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long minValue, long maxValue) {
        if (node == null) {
            return true;
        }

        if (node.val <= minValue || node.val >= maxValue) {
            return false;
        }

        return isValidBST(node.left, minValue, node.val) && isValidBST(node.right, node.val, maxValue);
    }

    //TC: O(N)
    //SC: O(h), where h is the height of the tree.
    // This accounts for the recursion stack in the worst case. For a balanced tree, this is O(logn);
    // for a skewed tree, it could be O(n).
}

