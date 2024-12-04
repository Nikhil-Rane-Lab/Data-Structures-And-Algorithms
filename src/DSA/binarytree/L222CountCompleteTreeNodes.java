package DSA.binarytree;

//https://leetcode.com/problems/count-complete-tree-nodes
public class L222CountCompleteTreeNodes {
//https://www.youtube.com/watch?v=u-yWemKGWO0

    public int countNodes(TreeNode root) {

        // Manually creating a complete binary tree:
        //          1
        //        /   \
        //       2     3
        //      / \   /
        //     4   5 6

        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if (leftHeight == rightHeight) { //it means its not just a "COMPLETE" but a "PERFECT" Binary Tree.
            return (int) Math.pow(2, leftHeight) - 1; //memorise: this is the formula to get the total number of nodes in a "PERFECT" binary search tree.
        } else {
            // Otherwise, recursively count nodes in left and right subtrees
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
}

// A complete binary tree is defined such that every level, except possibly the last, is fully filled, and all nodes are
// as far left as possible at the last level.
// A perfect binary tree is a type of complete binary tree where all levels are fully filled.
// TC: O((log n)^2) because calculating the depth is O(logn) and this is done for each level.
// SC: O(log n)