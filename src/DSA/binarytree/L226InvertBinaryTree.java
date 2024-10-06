package DSA.binarytree;

//https://leetcode.com/problems/invert-binary-tree
public class L226InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    //TC: O(n)
    //SC: O(h) where h is the height of the binary tree.
    //where h can range from O(logn) (for a balanced tree) to O(n) (for a skewed tree).

}
