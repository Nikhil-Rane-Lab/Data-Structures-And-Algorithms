package DSA.binarytree;

public class KthSmallestElementInBST {

    int count = 0;
    int result;
    public int kthSmallest(TreeNode root, int k) {

        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inOrderTraversal(node.right, k);
    }

    //TC: O(N)
    //SC: O(N)
    // The space complexity is O(h), where h is the height of the tree. This is due to the recursive call stack used during the in-order traversal.
    // In the worst case, the space complexity can be O(n) for a completely unbalanced tree, but it is O(logn) for a balanced tree.
}