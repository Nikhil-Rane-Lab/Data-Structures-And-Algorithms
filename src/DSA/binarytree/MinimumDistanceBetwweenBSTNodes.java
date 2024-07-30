package DSA.binarytree;

//https://leetcode.com/problems/minimum-distance-between-bst-nodes
//https://leetcode.com/problems/minimum-absolute-difference-in-bst
public class MinimumDistanceBetwweenBSTNodes {

    //APPROACH:
    // in-order traversal yields the node values in a sorted order.
    // Thus, the minimum absolute difference will be between two consecutive nodes in this sorted sequence.
    int minDiff;
    Integer prev;
    public int minDiffInBST(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        inOrderTraversal(root);
        return minDiff;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;

        inOrderTraversal(node.right);
    }

    //TC: O(N), where N is the number of nodes in the BST. This is because we visit each node exactly once during the in-order traversal.
    // SC: O(H), where H is the height of the tree. This is the space used by the recursion stack during the in-order traversal.
    // In the worst case, H can be N (in case of a skewed tree), but in a balanced tree, H is log(N).
}
