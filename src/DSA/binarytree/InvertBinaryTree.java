package DSA.binarytree;

//https://leetcode.com/problems/invert-binary-tree
public class InvertBinaryTree {

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
//    The space complexity is determined by the recursion stack. In the worst case, the recursion depth can be equal to the height of the tree. In a balanced binary tree, the height h is O(logn). However, in the worst case (skewed tree), hhh could be O(n).
//    Therefore, the space complexity mainly depends on the height of the binary tree, which affects the maximum depth of the function call stack during the recursion.


}
