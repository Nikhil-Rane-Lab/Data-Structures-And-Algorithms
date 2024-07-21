package DSA.binarytree;

//Q) https://leetcode.com/problems/diameter-of-binary-tree/description/
public class L543DiameterOfBinaryTree {
//https://www.youtube.com/watch?v=Rezetez59Nk

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        // Update the diameter if the path through the current node is larger
        diameter = Math.max(diameter, leftHeight + rightHeight); //⭐ this is a global variable

        // Return the depth of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    //TC: O(n), where n is the number of nodes in the tree, because each node is visited once.
    //SC: O(h), where h is the height of the tree, due to the recursion stack.
}
