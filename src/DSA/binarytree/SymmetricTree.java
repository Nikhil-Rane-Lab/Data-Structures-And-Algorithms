package DSA.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/symmetric-tree
public class SymmetricTree {

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

        if (t1 == null || t2 == null) {
            return false;
        }

        return (t1.val == t2.val)
                   && isMirror(t1.left, t2.right)
                  && isMirror(t1.right, t2.left);
    }

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

    /**
     * Time Complexity:
     * Recursive Approach:
     * For the recursive approach, the time complexity is O(n), where n is the number of nodes in the tree.
     * Explanation:
     * Space Complexity:
     * Recursive Approach:
     * The space complexity of the recursive approach is O(h), where h is the height of the tree.
     * Explanation:
     * The space complexity is determined by the maximum depth of the recursion stack.
     * In the worst case, the height h can be equal to n (for a completely unbalanced tree).
     * In the best case (for a balanced tree), the height h is O(logn).
     * Thus, the space complexity is O(h), which can range from O(logn) to O(n).
     * Iterative Approach:
     * The space complexity of the iterative approach is O(n)), where n is the number of nodes in the tree.
     * Explanation:
     * The space complexity is determined by the maximum number of nodes in the queue at any point in time.
     * In the worst case (for a perfectly balanced tree), the queue can contain up to n/2 nodes at the last level.
     * For a skewed tree, the queue can contain O(n) nodes.
     * Thus, the space complexity is O(n) in the worst case.
     * Summary:
     * Time Complexity (TC): O(n) for both recursive and iterative approaches, where nnn is the number of nodes in the tree.
     * Space Complexity (SC):
     * Recursive approach: O(h), where h is the height of the tree (can range from O(logn).
     * Iterative approach: O(n) in the worst case, where n is the number of nodes in the tree.
     */
}
