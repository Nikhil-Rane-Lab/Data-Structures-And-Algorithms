package DSA.binarytree;

//https://leetcode.com/problems/average-of-levels-in-binary-tree
public class L124BinaryTreeMaximumPathSum {
//https://www.youtube.com/watch?v=WszrfSwMz58

    int maxPathSum;
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxPathSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively call maxGain for the left and right subtrees
        int left = Math.max(0, maxGain(node.left)); //⭐ We ignore maxGain(node.left) if it's negative because it would
        // reduce the total path sum. Instead of taking the full path through the subtree, we only take a "half path"
        // by excluding the negative contribution, ensuring the sum is maximized.
        int right = Math.max(0, maxGain(node.right)); // same as above

        // The price of the current path which includes the current node
        int currPathSum = left + right + node.val;
        maxPathSum = Math.max(maxPathSum, currPathSum);// Update maxPathSum if the currPathSum is higher

        // Return the maximum gain the current node and one of its subtrees can contribute
        return node.val + Math.max(left, right);
    }

    //TC: O(N), where N is the number of nodes in the binary tree.
    // This is because each node is visited exactly once during the depth-first search traversal.

    //SC: O(H), where H is the height of the binary tree.
    // This can range from O(logN) in a balanced tree to O(N) in a skewed tree.
}
