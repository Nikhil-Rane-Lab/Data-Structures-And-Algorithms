package DSA.binarytree;

//https://leetcode.com/problems/path-sum
public class PathSum {

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
    //The time complexity of this solution is O(N), where N is the number of nodes in the tree.
    // In the worst case, we might visit all the nodes.
    //SC: O(h)
    //The space complexity is O(H), where H is the height of the tree.
    //This is because of the recursion stack. In the worst case (for a completely unbalanced tree),
    //the height of the tree could be N, resulting in O(N) space complexity.
    //For a balanced tree, the height is O(logN), resulting in O(N) space complexity.

}
