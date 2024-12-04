package DSA.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/symmetric-tree
public class L101SymmetricTree {
//this question is SIMILAR BUT NOT SAME to L100SameTree

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {  //⚠️ this condition CANNOT be replaced by if (t1 != null || t2 != null) { return false}
            // as one node being null is sufficient enough to say that the nodes are not similar but both node being not null is
            // not enough to say that they are similar as we also would then have to check their children subtrees values.
            return false;
        }

        return (t1.val == t2.val)
                   && isMirror(t1.left, t2.right)
                   && isMirror(t1.right, t2.left);
    }

//      Time Complexity:
//      TC: O(n), where n is the number of nodes in the tree.
//      SC: O(h), which can range from O(logn) to O(n).

    public boolean isSymmetric2(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) {
                continue;
            }

            if (t1 == null || t2 == null) {
                return false;
            }

            if (t1.val != t2.val) { //⭐ having same value here does not guarantee symmetricity but having different values guarantee it.
                return false;
            }

            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }

        return true;
    }

// TC: O(n)
// SC: O(n) in the worst case (for a full tree with maximum nodes at the last level),
// but for a balanced tree, it is O(log n) due to the depth of the tree.
// The queue will store nodes from the widest level of the tree.
}
