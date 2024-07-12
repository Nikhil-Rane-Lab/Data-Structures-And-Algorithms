package DSA.binarytree;

//Q) https://leetcode.com/problems/same-tree
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // If both nodes are null, they are the same
        if (p == null && q == null) {
            return true;
        }

        // If one node is null and the other is not, they are not the same
        if (p == null || q == null) {
            return false;
        }

        // Check the value of the current nodes and recursively check the left and right subtrees
        return (p.val == q.val)
                    && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);
    }

    //TC: O(n) The function traverses each node in both trees exactly once
    //SC: O(h) where h is the height of the tree.
    //The space complexity is determined by the recursion stack.
    //  1) In the worst case, the height of the tree can be equal to the number of nodes in the tree,
    //     which happens when the tree is skewed (all nodes are on one side).
    //  2) For a balanced tree, the height h is O(logn).
    //So, the space complexity is O(h), where ℎ h can range from O(logn) (for a balanced tree) to O(n) (for a skewed tree).
}
