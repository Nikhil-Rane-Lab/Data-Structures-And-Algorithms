package DSA.binarytree;

//https://leetcode.com/problems/minimum-absolute-difference-in-bst
public class L530MinimumAbsoluteDifference {

    int minDiff;
    TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        prev = null;
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev.val);
        }
        prev = node;

        inOrder(node.right);
    }

    //TC: O(N)
    //SC: O(H) where H ranges from N (completely unbalanced/skewed tree) to log(N) (balanced tree).
}
