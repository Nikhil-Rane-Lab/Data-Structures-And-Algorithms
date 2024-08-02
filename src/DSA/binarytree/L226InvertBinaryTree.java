package DSA.binarytree;

//https://leetcode.com/problems/invert-binary-tree
public class L226InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    //TC: O(n)
    //SC: O(h) where h is the height of the binary tree.
    //where h can range from O(logn) (for a balanced tree) to O(n) (for a skewed tree).

}
