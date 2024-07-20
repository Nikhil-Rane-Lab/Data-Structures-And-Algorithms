package DSA.binarytree;

import java.util.HashMap;
import java.util.Map;

//Q) https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
//https://www.youtube.com/watch?v=LgLRTaEMRVc

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndexMap.put(inOrder[i], i);
        }

        return constructBinaryTree(inOrder, 0, inOrder.length - 1,
                postOrder, 0, postOrder.length - 1,
                inOrderIndexMap);
    }

    private TreeNode constructBinaryTree(int[] inOrder, int inStart, int inEnd,
                                         int[] postOrder, int postStart, int postEnd,
                                         Map<Integer, Integer> inOrderIndexMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // The last element in the postorder array is the root of the current subtree
        int rootValue = postOrder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        // Root splits inorder list into left and right subtrees
        Integer inOrderRootIndex = inOrderIndexMap.get(rootValue);
        int leftSubTreeSize = inOrderRootIndex - inStart;

        // Recursively build the left subtree
        root.left = constructBinaryTree(inOrder, inStart, inOrderRootIndex - 1,
                                        postOrder, postStart, postStart + leftSubTreeSize - 1,
                                        inOrderIndexMap);

        // Recursively build the right subtree
        root.right = constructBinaryTree(inOrder, inOrderRootIndex + 1, inEnd,
                                         postOrder, postStart + leftSubTreeSize, postEnd - 1,
                                         inOrderIndexMap);

        return root;
    }

    //TC: O(n)
    //SC: O(n)
    // In the worst case, the depth of the recursion will be equal to the height of the tree.
    // In the worst case of a completely unbalanced tree (like a linked list),
    // the recursion depth will be O(n). In the best case of a balanced tree, the recursion depth will be O(log n).
}
