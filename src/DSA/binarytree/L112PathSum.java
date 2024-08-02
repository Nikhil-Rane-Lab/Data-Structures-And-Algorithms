package DSA.binarytree;

//https://leetcode.com/problems/path-sum
public class L112PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) { //means this is the leaf node
            return root.val == targetSum;
        }

        targetSum -= root.val;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    //TC: O(n)
    //SC: O(h)
    //SC: O(h) where h is the height of the tree.
    //where h can range from O(logn) (for a balanced tree) to O(n) (for a skewed tree).
}
