package DSA.binarytree;

import java.util.HashMap;
import java.util.Map;

//leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
public class L106ConstructBinaryTreeFromInorderAndPostorderTraversal {
//https://www.youtube.com/watch?v=LgLRTaEMRVc

    int postOrderIndex;
    Map<Integer, Integer> inOrderValueToIndexMap;
    public TreeNode buildTree1(int[] inOrder, int[] postOrder) {
        postOrderIndex = postOrder.length - 1; //⭐
        inOrderValueToIndexMap = new HashMap<>();

        // Map inorder values to their indices
        for (int i = 0; i < inOrder.length; i++) {
            inOrderValueToIndexMap.put(inOrder[i], i);
        }

        return constructBinaryTree(postOrder, 0, inOrder.length - 1);
    }

    private TreeNode constructBinaryTree(int[] postOrder, int inOrderStart, int inOrderEnd) {
        if (inOrderStart > inOrderEnd) {
            return null;
        }

        // Get the root value from the postorder array
        int val = postOrder[postOrderIndex--];
        TreeNode root = new TreeNode(val);

        // Root splits inorder list into left and right subtrees
        Integer inOrderIndex = inOrderValueToIndexMap.get(val);

        // ⭐ Build the right subtree first because of the postorder traversal
        root.right = constructBinaryTree(postOrder, inOrderIndex + 1, inOrderEnd);
        root.left = constructBinaryTree(postOrder, inOrderStart, inOrderIndex - 1);
        return root;
    }

    //*********************************************************************************************************************
    public TreeNode buildTree2(int[] inOrder, int[] postOrder) {
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndexMap.put(inOrder[i], i);
        }

        return constructBinaryTree(0, inOrder.length - 1,
                postOrder, 0, postOrder.length - 1,
                inOrderIndexMap);
    }

    private TreeNode constructBinaryTree(int inStart, int inEnd,
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
        root.left = constructBinaryTree(inStart, inOrderRootIndex - 1,
                postOrder, postStart, postStart + leftSubTreeSize - 1,
                inOrderIndexMap);

        // Recursively build the right subtree
        root.right = constructBinaryTree(inOrderRootIndex + 1, inEnd,
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
