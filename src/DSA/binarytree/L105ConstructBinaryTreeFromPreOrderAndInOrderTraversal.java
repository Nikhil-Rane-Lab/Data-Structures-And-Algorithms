package DSA.binarytree;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
public class L105ConstructBinaryTreeFromPreOrderAndInOrderTraversal {
// https://www.youtube.com/watch?v=aZNaLrVebKQ

    int preOrderIndex;
    Map<Integer, Integer> inOrderValueToIndexMap;

    public TreeNode buildTree1(int[] preOrder, int[] inOrder) {
        preOrderIndex = 0; //⭐
        inOrderValueToIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) { // Build a hashmap to store the value -> index relations
            inOrderValueToIndexMap.put(inOrder[i], i);
        }

        return constructBinaryTree(preOrder, 0, inOrder.length - 1);
    }

    public TreeNode constructBinaryTree(int[] preOrder, int inOrderStart, int inOrderEnd) {
        if (inOrderStart > inOrderEnd) { // If there are no elements to construct the tree
            return null;
        }

        // Select the preOrderIndex element as the root and increment it
        int val = preOrder[preOrderIndex++];
        TreeNode treeNode = new TreeNode(val); // this will be the root of the tree / sub-tree

        // Build the left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        Integer inOrderIndex = inOrderValueToIndexMap.get(val);
        treeNode.left = constructBinaryTree(preOrder, inOrderStart, inOrderIndex - 1);
        treeNode.right = constructBinaryTree(preOrder, inOrderIndex + 1, inOrderEnd);
        return treeNode;
    }

// TC: O(n)
// SC: O(n)

    //********************************************************************************************************************************
    public TreeNode buildTree2(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inOrderValueToIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderValueToIndexMap.put(inorder[i], i);
        }

        return constructBinaryTree(preorder, 0, 0, preorder.length - 1, inOrderValueToIndexMap);
    }

    private TreeNode constructBinaryTree(int[] preorder, int preOrderStart, int inOrderStart, int inOrderEnd, Map<Integer, Integer> inMap) {

        if (inOrderStart > inOrderEnd) {
            return null;
        }

        int val = preorder[preOrderStart];
        TreeNode root = new TreeNode(val);

        Integer inOrderRootIndex = inMap.get(val);
        int leftSubTreeSize = inOrderRootIndex - inOrderStart;

        root.left = constructBinaryTree(preorder, preOrderStart + 1, inOrderStart, inOrderRootIndex - 1, inMap);
        root.right = constructBinaryTree(preorder, preOrderStart + leftSubTreeSize + 1, inOrderRootIndex + 1, inOrderEnd, inMap);

        return root;
    }


}
