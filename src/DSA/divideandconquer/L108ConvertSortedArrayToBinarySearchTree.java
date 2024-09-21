package DSA.divideandconquer;

import DSA.binarytree.TreeNode;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description
public class L108ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        // Choose the middle element as the root
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build the left and right subtrees
        root.left = constructBST(nums, left, mid - 1);
        root.right = constructBST(nums, mid + 1, right);

        return root;
    }
}

// TC: O(n) - The algorithm processes each element exactly once by recursively dividing the array.
// The work done at each level is proportional to the number of elements being processed,
// and since the depth of recursion is O(logn), the total time complexity is  O(n).

// SC: O(logn) - Due to the recursion stack, as the recursion depth is proportional to the height of the tree,
// which is O(logn) for a balanced tree.
