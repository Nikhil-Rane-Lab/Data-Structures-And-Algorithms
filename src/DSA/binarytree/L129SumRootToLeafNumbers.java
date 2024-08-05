package DSA.binarytree;

public class L129SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {

        if (node == null) {
            return 0;
        }

        currentSum = (currentSum * 10) + node.val;  // Update the current number formed by this path

        if (node.left == null && node.right == null) {
            // Leaf node, return the current number
            return currentSum;
        }

        // Recur for left and right subtrees and sum the results
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }

    //TC: O(N)
    //SC: O(N)
}
