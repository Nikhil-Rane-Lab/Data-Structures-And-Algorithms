package DSA.binarytree;

//Q) https://leetcode.com/problems/same-tree
public class L100SameTree {
//this question is similar to L101SymmetricTree

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // If both nodes are null, they are the same
        if (p == null && q == null) {
            return true;
        }

        // If one node is null and the other is not, they are not the same
        if (p == null || q == null) { //⚠️ this condition CANNOT be replaced by if (p != null || q != null) { return false}
            return false;
        }

        // Check the value of the current nodes and recursively check the left and right subtrees
        return (p.val == q.val)
                    && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);
    }

// TC: O(n) The function traverses each node in both trees exactly once
// SC: O(h) where h is the height of the tree.
// where h can range from O(logn) (for a balanced tree) to O(n) (for a skewed tree).
}
