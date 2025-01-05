package DSA.binarytree;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/description
public class L129SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

   // ⚠️ We are using perOrder traversal here as number are to be constructed in that order only ie., from root to leaf
    private int dfs(TreeNode node, int currNum) {

        if (node == null) {
            return 0;
        }

        currNum = (currNum * 10) + node.val;  // Update the current number formed (till now) by this path

        if (node.left == null && node.right == null) {
            // Leaf node, return the fully formed current number
            return currNum;
        }

        // Recur for left and right subtrees and sum the results
        int leftNum = dfs(node.left, currNum);
        int rightNum = dfs(node.right, currNum);
        return leftNum + rightNum;
    }

    //TC: O(n)
    //SC: O(h)
}
