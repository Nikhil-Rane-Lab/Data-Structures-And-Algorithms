package DSA.binarytree;

//Q) https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
public class LowestCommonAncestorOfABinaryTree {
//https://www.youtube.com/watch?v=_-QHfMDde90

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null, or root is one of p or q, then return root
        if (root == null || p == root || q == root) {
            return root;
        }

        // Recursively search for LCA in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            // If both left and right are not null, this means p and q are found in different
            // subtrees, so root is their LCA
            return root;
        }
    }
}

//TC: O(n) where N is the number of nodes in the tree.
// This is because, in the worst case, we might have to visit all the nodes.
//SC : O(h) O(H), where H is the height of the tree. This is due to the recursion stack,
// which in the worst case of a skewed tree, can be equal to the number of nodes.
// In a balanced tree, it would be log(N).
